//package conf;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * 基于Servlet3.0的，相当于以前<b>web.xml</b>配置文件的配置类
// *
// * @author OneCoder
// * @Blog http://www.coderli.com
// * @date 2012-9-30 下午1:16:59
// */
//public class DefaultWebApplicationInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext appContext) throws ServletException {
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(DefaultAppConfig.class);
//
//		appContext.addListener(new ContextLoaderListener(rootContext));
//
//		ServletRegistration.Dynamic dispatcher = appContext.addServlet( "dispatcher", new DispatcherServlet(rootContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//		dispatcher.setAsyncSupported(true);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~ DefaultWebApplicationInitializer");
//
//	}
//}