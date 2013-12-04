package com.config;

import java.net.URISyntaxException;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	private static BasicDataSource basicDataSource;
	
	static {
		basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_fca06dcb390cb0f?reconnect=true");
        basicDataSource.setUsername("b48516fc807a21");
        basicDataSource.setPassword("66a715a2");
	}
	
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        return basicDataSource;
    }
}