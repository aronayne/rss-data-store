package com.config;

import java.net.URISyntaxException;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_fca06dcb390cb0f?reconnect=true");
        basicDataSource.setUsername("b48516fc807a21");
        basicDataSource.setPassword("66a715a2");

        return basicDataSource;
    }
}