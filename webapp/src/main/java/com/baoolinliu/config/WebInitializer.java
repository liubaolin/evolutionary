package com.baoolinliu.config;

import com.baoolinliu.AppConfig;
import com.baoolinliu.SecurityConfig;
import com.baoolinliu.SpringConfig;
import org.springframework.core.annotation.Order;

/**
 * Created by richey on 17-3-12.
 */
@Order(3)
public class WebInitializer extends AbstractModuleConfiguration{


    @Override
    protected void doConfig() {
        addRootConfigClasses(AppConfig.class,SecurityConfig.class);
        addServletConfigClasses(SpringConfig.class);
    }
}
