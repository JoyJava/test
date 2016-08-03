//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.AsyncContext;
//import javax.servlet.AsyncEvent;
//import javax.servlet.AsyncListener;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.*;
//
///**
// * User: fh
// * Date: 16/5/27 18:07
// */
//@RequestMapping
//public class TestController {
//   private static     int asyncTimeoutInSeconds = 10 ;
//    @RequestMapping("/book")
//    public void getBook(HttpServletRequest request, @RequestParam(value="skuId") final Long skuId,
//                        @RequestParam(value="cat1") final Integer cat1, @RequestParam(value="cat2") final Integer cat2) throws Exception {
//
////        oneLevelAsyncContext.submitFuture(request, () -> bookService.getBook(skuId, cat1, cat2));
//    }
//
//
//    public void submitFuture(final HttpServletRequest req, final Callable<Object> task) {
//        final String uri = req.getRequestURI();
//        final Map<String, String[]> params = req.getParameterMap();
//        final AsyncContext asyncContext = req.startAsync();  //开启异步上下文
//        asyncContext.getRequest().setAttribute("uri", uri);
//        asyncContext.getRequest().setAttribute("params", params);
//        asyncContext.setTimeout(asyncTimeoutInSeconds * 1000);
//        if(asyncListener != null) {
//            asyncContext.addListener(asyncListener);
//        }
//        executor.submit(new CanceledCallable(asyncContext) { //提交任务给业务线程池
//            @Override
//            public Object call() throws Exception {
//                Object o = task.call();  //业务处理调用
//                if(o == null) {
//                    callBack(asyncContext, o, uri, params);  //业务完成后，响应处理
//                }
//                if(o instanceof CompletableFuture) {
//                    CompletableFuture<Object> future = (CompletableFuture<Object>)o;
//                    future.thenAccept(resultObject -> callBack(asyncContext, resultObject, uri, params))
//                            .exceptionally(e -> {
//                                callBack(asyncContext, "", uri, params);
//                                return null;
//                            });
//                } else if(o instanceof String) {
//                    callBack(asyncContext, o, uri, params);
//                }
//                return null;
//            }
//        });
//    }
//
//    private void callBack(AsyncContext asyncContext, Object result, String uri, Map<String, String[]> params) {
//        HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
//        try {
//            if(result instanceof String) {
//                write(resp, (String)result);
//            } else {
//                write(resp, JSONUtils.toJSON(result));
//            }
//        } catch (Throwable e) {
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //程序内部错误
//            try {
//                LOG.error("get info error, uri : {},  params : {}", uri, JSONUtils.toJSON(params), e);
//            } catch (Exception ex) {
//            }
//        } finally {
//            asyncContext.complete();
//        }
//    }
//
//
//
//    public void afterPropertiesSet() throws Exception {
//        String[] poolSizes = poolSize.split("-");
//        //初始线程池大小
//        int corePoolSize = Integer.valueOf(poolSizes[0]);
//        //最大线程池大小
//        int maximumPoolSize = Integer.valueOf(poolSizes[1]);
//        queue = new LinkedBlockingDeque<Runnable>(queueCapacity);
//        executor = new ThreadPoolExecutor(
//                corePoolSize, maximumPoolSize,
//                keepAliveTimeInSeconds, TimeUnit.SECONDS,
//                queue);
//
//        executor.allowCoreThreadTimeOut(true);
//        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                if(r instanceof CanceledCallable) {
//                    CanceledCallable cc = ((CanceledCallable) r);
//                    AsyncContext asyncContext = cc.asyncContext;
//                    if(asyncContext != null) {
//                        try {
//                            String uri = (String) asyncContext.getRequest().getAttribute("uri");
//                            Map params = (Map) asyncContext.getRequest().getAttribute("params");
//                            LOG.error("async request rejected, uri : {}, params : {}", uri, JSONUtils.toJSON(params));
//                        } catch (Exception e) {}
//                        try {
//                            HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
//                            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//                        } finally {
//                            asyncContext.complete();
//                        }
//                    }
//                }
//            }
//        });
//
//        if(asyncListener == null) {
//            asyncListener = new AsyncListener() {
//                @Override
//                public void onComplete(AsyncEvent event) throws IOException {
//                }
//
//                @Override
//                public void onTimeout(AsyncEvent event) throws IOException {
//                    AsyncContext asyncContext = event.getAsyncContext();
//                    try {
//                        String uri = (String) asyncContext.getRequest().getAttribute("uri");
//                        Map params = (Map) asyncContext.getRequest().getAttribute("params");
//                        LOG.error("async request timeout, uri : {}, params : {}", uri, JSONUtils.toJSON(params));
//                    } catch (Exception e) {}
//                    try {
//                        HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
//                        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//                    } finally {
//                        asyncContext.complete();
//                    }
//                }
//
//                @Override
//                public void onError(AsyncEvent event) throws IOException {
//                    AsyncContext asyncContext = event.getAsyncContext();
//                    try {
//                        String uri = (String) asyncContext.getRequest().getAttribute("uri");
//                        Map params = (Map) asyncContext.getRequest().getAttribute("params");
//                        LOG.error("async request error, uri : {}, params : {}", uri, JSONUtils.toJSON(params));
//                    } catch (Exception e) {}
//                    try {
//                        HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
//                        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//                    } finally {
//                        asyncContext.complete();
//                    }
//                }
//
//                @Override
//                public void onStartAsync(AsyncEvent event) throws IOException {
//
//                }
//            };
//        }
//
//    }
//
//
//
//}
