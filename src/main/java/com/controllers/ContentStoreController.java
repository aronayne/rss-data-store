package com.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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


	/*
	 * @Autowired private PersonService personService;
	 */
	@RequestMapping(value = "/addToDatabase", method = RequestMethod.GET)
	@ResponseBody
	public String addToDatabase() throws SQLException {


		ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		BasicDataSource basicDataSource = context.getBean(BasicDataSource.class);
		Connection connection = basicDataSource.getConnection();		
		Statement stmt = connection.createStatement();
		stmt.execute("INSERT INTO heroku_fca06dcb390cb0f.`rss-data` (feedType , description) VALUES (\"test\" , \"test\")");
		java.sql.ResultSet rs = stmt.executeQuery("SELECT COUNT(*) from heroku_fca06dcb390cb0f.`rss-data`");
		int totalRecords = 0;
		while(rs.next()){
			totalRecords = rs.getInt(1);
		}
		stmt.close();
		connection.close();
		
		return getFeed()+"Record Inserted"+totalRecords;
	}
	
	private String getFeed(){
		
		URL url;
		String totalContent = "";
		
		try {

			url = new URL("http://feeds.arsenal.com/arsenal-news?format=xml");
			URLConnection conn = url.openConnection();
 
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine = "";

			
			while ((inputLine = br.readLine()) != null) {
				totalContent += inputLine;
			}

			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return totalContent;
	}

}
