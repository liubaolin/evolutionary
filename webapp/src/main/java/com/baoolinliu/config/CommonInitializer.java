package com.baoolinliu.config;

import com.baoolinliu.servlet.DemoServlet;
import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by richey on 17-3-11.
 */
@Order(1)
public class CommonInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //Log4jConfigListener
   /*     servletContext.setInitParameter("log4jConfigLocation", "classpath:config/properties/log4j.properties");
        servletContext.addListener(Log4jConfigListener.class);
    */

  /*      //OpenSessionInViewFilter
        OpenSessionInViewFilter hibernateSessionInViewFilter = new OpenSessionInViewFilter();
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(  "hibernateFilter", hibernateSessionInViewFilter);
        filterRegistration.addMappingForUrlPatterns(  EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");

        //DemoServlet
        DemoServlet demoServlet = new DemoServlet();
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("demoServlet", demoServlet);
        dynamic.setLoadOnStartup(2);
        dynamic.addMapping("/demo_servlet");*/

    }
}
