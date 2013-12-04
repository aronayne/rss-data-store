package com.example;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("getResponse")
public class PersonController {

	/*
	 * @Autowired private PersonService personService;
	 */
	@RequestMapping(value = "/addToDatabase", method = RequestMethod.GET)
	@ResponseBody
	public String addToDatabase() throws SQLException {
		
	
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		BasicDataSource basicDataSource = context.getBean(BasicDataSource.class);

		basicDataSource.getConnection().createStatement().execute("INSERT INTO heroku_fca06dcb390cb0f.`rss-data` (feedType , description) VALUES (\"test\" , \"test\")");
		
		return "Record Inserted";
	}

	/*
	 * @RequestMapping("/") public String listPeople(Map<String, Object> map) {
	 * 
	 * map.put("person", new Person()); map.put("peopleList",
	 * personService.listPeople());
	 * 
	 * return "people"; }
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.POST) public
	 * String addPerson(@ModelAttribute("person") Person person, BindingResult
	 * result) {
	 * 
	 * personService.addPerson(person);
	 * 
	 * return "redirect:/people/"; }
	 * 
	 * @RequestMapping("/delete/{personId}") public String
	 * deletePerson(@PathVariable("personId") Integer personId) {
	 * 
	 * personService.removePerson(personId);
	 * 
	 * return "redirect:/people/"; }
	 */
}
