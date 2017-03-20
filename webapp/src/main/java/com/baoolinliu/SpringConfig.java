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
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

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
        exceptionResolvers.add(new SimpleMappingExceptionResolver());
        exceptionResolvers.add(new ResponseStatusExceptionResolver());
        exceptionResolvers.add(new ExceptionHandlerExceptionResolver());
        exceptionResolvers.add(new DefaultHandlerExceptionResolver());
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
