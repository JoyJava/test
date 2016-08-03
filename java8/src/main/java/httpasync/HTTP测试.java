package httpasync;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;

import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * User: fh
 * Date: 16/4/20 15:54
 */
public class HTTP测试 {

    /**
     * 连接超时时间
     */
    public final static int connectTimeout = 2500;

    /**
     * socket连接超时时间
     */
    public final static int socketTimeout = 2500;

    /**
     * 发送请求相应时间
     */
    public final static int requestTimeout = 2500;

    /**
     * 连接管理器
     */
    public static PoolingNHttpClientConnectionManager cm;

    /**
     * 最大连接数
     */
    public final static int MAX_TOTAL_CONNECTIONS = 500;
    /**
     * 每个路由最大连接数 访问每个目标机器 算一个路由 默认 2个
     */
    public final static int MAX_ROUTE_CONNECTIONS = 800;

    private final static ConnectionConfig connectionConfig = ConnectionConfig.custom()
            .setCharset(Consts.UTF_8)
            .setMalformedInputAction(CodingErrorAction.IGNORE)
            .setUnmappableInputAction(CodingErrorAction.IGNORE).build();


    private final static RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.DEFAULT)
            .setExpectContinueEnabled(true)
            .setRedirectsEnabled(true)
            .setConnectTimeout(connectTimeout)
            .setSocketTimeout(socketTimeout)
            .setConnectionRequestTimeout(requestTimeout)
            .build();
    private final static IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
            .setIoThreadCount(Runtime.getRuntime().availableProcessors())
            .setConnectTimeout(connectTimeout)
            .setSoTimeout(socketTimeout)
            .build();


    public final static CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
            .setDefaultCookieStore(new BasicCookieStore())
            .setConnectionManager(cm)
            .setDefaultRequestConfig(defaultRequestConfig)
            .setDefaultConnectionConfig(connectionConfig).build();

    static {
        ConnectingIOReactor ioReactor = null;
        try {
            // Create I/O reactor configuration
            ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
            cm = new PoolingNHttpClientConnectionManager(ioReactor);
        } catch (IOReactorException e) {
            throw new RuntimeException(e);
        }
        cm.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);// 设置最大路由数
        cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);// 最大连接数
    }

    String API_XIGNITE_USERNAME = "jiawei.bao@jimu.com";
    String API_XIGNITE_TOKEN = "DBEC7AE6E4C04ECEAE8F3F5F002D3C80";

    public static void main(String[] args) throws Exception {
        String ss = "";
        String url = "http://globalquotes.xignite.com/v3/xGlobalQuotes.json/GetGlobalDelayedQuotes?_Token=DBEC7AE6E4C04ECEAE8F3F5F002D3C80&Username=jiawei.bao@jimu.com&IdentifierType=Symbol&Identifiers=" ;

        String[] strings = ss.split(",");
//        for (int i = 0; i < strings.length/500; i++) {
//        CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
//                .setDefaultCookieStore(new BasicCookieStore())
//                .setConnectionManager(cm)
//                .setDefaultRequestConfig(defaultRequestConfig)
//                .setDefaultConnectionConfig(connectionConfig).build();
        httpClient.start();

        int take = 10 ;
        for (int i = 0; i < strings.length/take; i++) {
            String s = Arrays.asList(strings).stream().skip(i * take).limit(take).collect(Collectors.joining(","));
//            String s = strings[i];
            HttpGet httpget = new HttpGet(url + s );
            httpClient.execute(httpget, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse result) {
                         System.out.println(" ~~~~~~~~~~~~ "+ (System.currentTimeMillis()));
                }

                @Override
                public void failed(Exception ex) {
                    ex.printStackTrace();
                }

                @Override
                public void cancelled() {
                    System.out.println(" ~~~~~~~~~~~~ 0");

                }
            });
         }

     }

}
