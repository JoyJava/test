package httpasync;

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
 * User: fh
 * Date: 16/4/28 17:13
 */
public class Xignite测试 {
    String url = "https://stream.xignite.com/xNASDAQLastSale.json/GetExtendedQuotes?IdentifierType=Symbol&_token=DBEC7AE6E4C04ECEAE8F3F5F002D3C80&Identifiers=";
    private static String uri = "xNASDAQLastSale.json/GetExtendedQuotes?IdentifierType=Symbol&_token=DBEC7AE6E4C04ECEAE8F3F5F002D3C80&Identifiers=";

    public static void main(final String[] args) throws Exception {
//        for (int i = 0; i < 20; i++) {
//            new Thread(AsyncClientPipelinedStreaming::a).start();
        a();
//        }
    }

    public static void a() {
        long start = System.currentTimeMillis();
        CloseableHttpPipeliningClient httpclient = HttpAsyncClients.createPipelining();
        try {
            httpclient.start();

            HttpHost targetHost = new HttpHost("stream.xignite.com", 80);

            List<MyRequestProducer> requestProducers = new ArrayList<MyRequestProducer>();
            List<MyResponseConsumer> responseConsumers = new ArrayList<MyResponseConsumer>();
//            String[] codes = StockParser.stockCodeList.split(",");
            String[] codes = "MSFT,AAPL,GOOG".split(",");
//            500 * 17 组任务 ~~~~~~~~~~~~~~~ Shutting down 执行时间: 12660
//              avg=17348.1

//            400 * 21 组任务 ~~~~~~~~~~~~~~~ Shutting down 执行时间: 27476
//              avg=18923.8

            int take = 3;
            for (int i = 0; i < codes.length / take; i++) {
                String codeList = Arrays.asList(codes).stream().skip(i * take).limit(take).collect(Collectors.joining(","));

                HttpGet request = new HttpGet(uri + URLEncoder.encode(codeList.trim()));
                requestProducers.add(new MyRequestProducer(targetHost, request));
                responseConsumers.add(new MyResponseConsumer(request));
            }
            System.out.println("任务数量 = " + responseConsumers.size());

            Future<List<Boolean>> future = httpclient.execute(
                    targetHost, requestProducers, responseConsumers, new FutureCallback<List<Boolean>>() {
                        @Override
                        public void completed(List<Boolean> result) {
                            System.out.println(result.toString() + "~~~~~~~~~~~~~~");
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
            System.out.println("Request sent: " + this.request.getRequestLine());
        }
    }

    static class MyResponseConsumer extends AsyncCharConsumer<Boolean> {

        private final HttpRequest request;

        MyResponseConsumer(final HttpRequest request) {
            this.request = request;
        }

        @Override
        protected void onResponseReceived(final HttpResponse response) {
//            System.out.println(response.getStatusLine() +"  "+ request.getRequestLine().toString());
            System.out.println("            Response received: " + response.getStatusLine() + " -> " + this.request.getRequestLine());
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
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            return Boolean.TRUE;
        }

    }

}