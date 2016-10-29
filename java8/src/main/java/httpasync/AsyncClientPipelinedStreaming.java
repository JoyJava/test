/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package httpasync;

import httpParser.StockParser;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpPipeliningClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.protocol.BasicAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * This example demonstrates a pipelinfed execution of multiple HTTP request / response exchanges
 * with a full content streaming.
 */
public class AsyncClientPipelinedStreaming {
    String url = "http://globalquotes.xignite.com/v3/xGlobalQuotes.json/GetGlobalDelayedQuotes?_Token=DBEC7AE6E4C04ECEAE8F3F5F002D3C80&Username=jiawei.bao@jimu.com&IdentifierType=Symbol&Identifiers=";

    public static void main(final String[] args) throws Exception {
        for (int i = 0; i < 20; i++) {
//            new Thread(AsyncClientPipelinedStreaming::a).start();
            a();
        }
    }

    public static void a() {
        long start = System.currentTimeMillis();
        CloseableHttpPipeliningClient httpclient = HttpAsyncClients.createPipelining();
        try {
            httpclient.start();

            HttpHost targetHost = new HttpHost("globalquotes.xignite.com", 80);
//            HttpGet[] resquests = {
//                    new HttpGet("/docs/index.html"),
//                    new HttpGet("/docs/introduction.html"),
//                    new HttpGet("/docs/setup.html"),
//                    new HttpGet("/docs/config/index.html")
//            };

            List<MyRequestProducer> requestProducers = new ArrayList<MyRequestProducer>();
            List<MyResponseConsumer> responseConsumers = new ArrayList<MyResponseConsumer>();
            String[] codes = StockParser.stockCodeList.split(",");
//            500 * 17 组任务 ~~~~~~~~~~~~~~~ Shutting down 执行时间: 12660
//              avg=17348.1

//            400 * 21 组任务 ~~~~~~~~~~~~~~~ Shutting down 执行时间: 27476
//              avg=18923.8

            int take = 400;
            for (int i = 0; i < codes.length / take; i++) {
                String code = Arrays.asList(codes).stream().skip(i * take).limit(take).collect(Collectors.joining(","));
                HttpGet request = new HttpGet(StockParser.uri + URLEncoder.encode(code.trim()));
                requestProducers.add(new MyRequestProducer(targetHost, request));
                responseConsumers.add(new MyResponseConsumer(request));
            }
//            System.out.println("任务数量 = "+ responseConsumers.size());
//            for (HttpGet request: resquests) {
//                requestProducers.add(new MyRequestProducer(targetHost, request));
//                responseConsumers.add(new MyResponseConsumer(request));
//            }

            Future<List<Boolean>> future = httpclient.execute(
                    targetHost, requestProducers, responseConsumers, new FutureCallback<List<Boolean>>() {
                        @Override
                        public void completed(List<Boolean> result) {
                        }

                        @Override
                        public void failed(Exception ex) {
                            ex.printStackTrace();
                        }

                        @Override
                        public void cancelled() {

                        }
                    });
            future.get();
            System.out.println(take + " * " + responseConsumers.size() + " 组任务 ~~~~~~~~~~~~~~~ Shutting down 执行时间: " + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("Done");
    }

    static class MyRequestProducer extends BasicAsyncRequestProducer {

        private final HttpRequest request;

        MyRequestProducer(final HttpHost target, final HttpRequest request) {
            super(target, request);
            this.request = request;
        }

        @Override
        public void requestCompleted(final HttpContext context) {
            super.requestCompleted(context);
//            System.out.println("Request sent: " + this.request.getRequestLine() );
        }
    }

    static class MyResponseConsumer extends AsyncCharConsumer<Boolean> {

        private final HttpRequest request;

        MyResponseConsumer(final HttpRequest request) {
            this.request = request;
        }

        @Override
        protected void onResponseReceived(final HttpResponse response) {
            System.out.println(response.getStatusLine() + "  " + request.getRequestLine().toString());
//            System.out.println("            Response received: " + response.getStatusLine() + " -> " + this.request.getRequestLine()  );
        }

        @Override
        protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl) throws IOException {
            while (buf.hasRemaining()) {
                System.out.print(buf.get());
            }
        }

        @Override
        protected void releaseResources() {
        }

        @Override
        protected Boolean buildResult(final HttpContext context) {
//            System.out.println();
//            System.out.println( "=================================================");
//            System.out.println();
            return Boolean.TRUE;
        }

    }

}
