package com.example;

import java.net.URI;
import java.net.URISyntaxException;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {


    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {

    	
        //URI dbUri = new URI(System.getenv("DATABASE_URL"));
    	
    	//URI dbUri = new URI("us-cdbr-east-04.cleardb.com");
    	
        
       // String username = dbUri.getUserInfo().split(":")[0];
     //   String password = dbUri.getUserInfo().split(":")[1];
       // String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
     //   String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_fca06dcb390cb0f?reconnect=true");
        basicDataSource.setUsername("b48516fc807a21");
        basicDataSource.setPassword("66a715a2");

        return basicDataSource;
    }
}