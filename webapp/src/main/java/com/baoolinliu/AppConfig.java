package com.baoolinliu;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by richey on 17-3-12.
 */
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class AppConfig implements InitializingBean {

    public static final String MODUCLE_PATH = "com.baolinliu.module";

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    private Environment environment;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${site.host}")
    private String siteHost;

    @Value("${site.ctxPath}")
    private String ctxPath;

    @Bean(name = "appSiteHost")
    public String appSiteHost() {
        return siteHost;
    }

    @Bean(name = "appSiteCtxPath")
    public String appSiteCtxPath() {
        return ctxPath;
    }

    /*@Bean(name = "jsonSerializeFilters")
    public Set<BeanextSerializeFilter> serializerFilters() {
        return CollectUtils.newHashSet();
    }*/

    @Bean(name = "multipartResolver")
    //setMaxInMemorySize FIXME
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        return new CommonsMultipartResolver() {
            @Override
            public boolean isMultipart(HttpServletRequest request) {
                if (null == request) {
                    return false;
                }
                if (RequestMethod.POST.toString().equalsIgnoreCase(request.getMethod())
                        || RequestMethod.PUT.toString().equalsIgnoreCase(request.getMethod())) {
                    return FileUploadBase.isMultipartContent(new ServletRequestContext(request));
                }
                return false;
            }
        };
    }

    @Override
    public void afterPropertiesSet() throws Exception {
   /*     ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.setEnvironment(environment);
        provider.setResourceLoader(resourceLoader);
        provider.addIncludeFilter(new EnumTypeFilter());
        scanPersistModule(provider, "com.baolinliu.model");
        scanPersistModule(provider, "org.beanext.commons.entity");*/
    }


    private void scanPersistModule(ClassPathScanningCandidateComponentProvider provider,
                                   String packageName) throws ClassNotFoundException {
        /*for (BeanDefinition definition : provider.findCandidateComponents(packageName)) {
            Enums.addEnumAlias(definition.getBeanClassName());
        }*/
    }
}
