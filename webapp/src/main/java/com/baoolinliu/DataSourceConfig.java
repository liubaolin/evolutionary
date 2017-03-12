package com.baoolinliu;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("product")
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource prodDataSource() {
       /* HikariConfig config = new HikariConfig("/jdbc.prod.properties");
        return new HikariDataSource(config);*/
        //TODO
        return null;
    }
}
