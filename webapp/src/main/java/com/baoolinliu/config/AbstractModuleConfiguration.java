package com.baoolinliu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.util.*;

/**
 * Created by richey on 17-3-12.
 */
public abstract class AbstractModuleConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

    private Set<Class<?>> rootConfigClasses = new LinkedHashSet<Class<?>>();

    private Set<Class<?>> servletConfigClasses = new LinkedHashSet<Class<?>>();

    public void addRootConfigClasses(Class<?>... rootConfigClasses) {
        this.rootConfigClasses.addAll(Arrays.asList(rootConfigClasses));
    }

    public void addServletConfigClasses(Class<?>... servletConfigClasses) {
        this.servletConfigClasses.addAll(Arrays.asList(servletConfigClasses));
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        doConfig();
        Class<?>[] classes = this.rootConfigClasses.toArray(new Class<?>[rootConfigClasses.size()]);
        return classes;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        doConfig();
        Class<?>[] classes = this.servletConfigClasses.toArray(new Class<?>[servletConfigClasses.size()]);
        return classes;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        List<? extends Filter> filters = getFilters();
        return filters.toArray(new Filter[filters.size()]);
    }

    protected List<Filter> getFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(new HiddenHttpMethodFilter());
        filters.add(new HttpPutFormContentFilter());
        filters.add(characterEncodingFilter);
        return filters;
    }

    protected abstract void doConfig();
}
