package com.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

	private static Connection connection;
	
	static {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		BasicDataSource basicDataSource = context.getBean(BasicDataSource.class);
		try {
			connection = basicDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @Autowired private PersonService personService;
	 */
	@RequestMapping(value = "/addToDatabase", method = RequestMethod.GET)
	@ResponseBody
	public String addToDatabase() throws SQLException {



		//Connection connection = basicDataSource.getConnection();
		Statement stmt = connection.createStatement();
		stmt.execute("INSERT INTO heroku_fca06dcb390cb0f.`rss-data` (feedType , description) VALUES (\"test\" , \"test\")");
		java.sql.ResultSet rs = stmt.executeQuery("SELECT COUNT(*) from heroku_fca06dcb390cb0f.`rss-data`");
		int totalRecords = 0;
		while(rs.next()){
			totalRecords = rs.getInt(1);
		}
		stmt.close();
		//connection.close();
		
		return "Record Inserted"+totalRecords;
	}

}
