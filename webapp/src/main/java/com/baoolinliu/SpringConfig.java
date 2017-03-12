package com.baoolinliu;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.baolinliu.controller", AppConfig.MODUCLE_PATH})
@Import({
        DataSourceConfig.class
})
public class SpringConfig extends WebMvcConfigurerAdapter implements InitializingBean {


    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addWebRequestInterceptor(openSessionInViewInterceptor);
        /*registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor);
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(viewPathInterceptor);
        registry.addInterceptor(requestResponseHolder);
        registry.addInterceptor(new ActiveRegistmailAdapter());
        registry.addInterceptor(securityHandlerInterceptorAdapter);
        registry.addInterceptor(new StaffAccountDisabledInterceptorAdapter());
        registry.addInterceptor(new ResourceInterceptorAdapter());
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                SalaryCalcContext.destory();
            }
        });
        registry.addInterceptor(requestHandlerHolder);
        registry.addInterceptor(jsonRequestBodyHolder);
        //TODO 浏览器缓存设置,系统正式运行后开放注释
        registry.addInterceptor(new WebContentInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                int cacheSeconds = -1;
                if (handlerMethod.getBean() instanceof BaseCodeServiceImpl && handlerMethod.getMethod().getName().equals("getAll")) {
                    cacheSeconds = 600;
                } else if (handlerMethod.getBean() instanceof BaseEnumServiceImpl) {
                    cacheSeconds = 604800;
                }
                if (cacheSeconds > 0) {
                    applyCacheSeconds(response, cacheSeconds);
                    return true;
                }
                return super.preHandle(request, response, handler);
            }
        });*/
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        /*exceptionResolvers.add(new SimpleMappingExceptionResolver());
        exceptionResolvers.add(new ResponseStatusExceptionResolver());
        exceptionResolvers.add(new ExceptionHandlerExceptionResolver());
        exceptionResolvers.add(new DefaultHandlerExceptionResolver());*/
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // registry.add
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation returns {@code null}
     */
    @Override
    public Validator getValidator() {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }


    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {}


    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
