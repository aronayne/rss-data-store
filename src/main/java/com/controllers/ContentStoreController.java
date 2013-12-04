package com.controllers;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.config.DatabaseConfig;

@Controller
@RequestMapping("getResponse")
public class ContentStoreController {

	/*
	 * @Autowired private PersonService personService;
	 */
	@RequestMapping(value = "/addToDatabase", method = RequestMethod.GET)
	@ResponseBody
	public String addToDatabase() throws SQLException {

		ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		BasicDataSource basicDataSource = context.getBean(BasicDataSource.class);

		basicDataSource.getConnection().createStatement().execute("INSERT INTO heroku_fca06dcb390cb0f.`rss-data` (feedType , description) VALUES (\"test\" , \"test\")");
		
		return "Record Inserted";
	}

}
