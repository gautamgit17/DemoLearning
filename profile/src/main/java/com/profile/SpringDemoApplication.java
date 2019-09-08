package com.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

@SpringBootApplication
@Controller
public class SpringDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);

	@Value("${spring.application.name:SpringTesT}")
	private String name;

	@Value("${spring.id}")
	private int id;

	@Value("${spring.role}")
	private String role;
	
	@Autowired
	SpringJsonReturn jsonReturn;
	
	@Autowired
	ProductsCreateTable createTable;
	
	@Autowired
	ProductCreateDB createDB;
	
	@Autowired
	ProductReadDB productReadDB;
	
	@Autowired
	ProductQueryDB queryDB;

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@GetMapping(value = "/helo")
	@ResponseBody
	public String HelloWorld() {
		return name;

	}

	@GetMapping("/hello-world")
	@ResponseBody
	public SpringJsonReturn callJson(@RequestParam(name = "name", required = false) String name) {
		return jsonReturn;

	}

	@GetMapping("/hello-world-parameter")
	@ResponseBody
	public SpringJosnParameter callJson() {
		return new SpringJosnParameter(name, id, role);

	}
	@GetMapping("/Creat-Dynamo")
	public void createDynamoTable() {
		createTable.createDynamoTable();
		
	}
	
	@GetMapping("/Creat-Dynamo-Product")
	public void createProduct() {
		 createDB.createProduct(2019, "LukaChipi");
	}
	
	@GetMapping("/Read-Dynamo-Product")
	@ResponseBody
	public String readProduct() {
		return productReadDB.readProduct(2019).toJSON();
	}
	
	@GetMapping("/Read")
	@ResponseBody
	public ResponseEntity<?> getItemDB() {
		ResponseEntity<?> entity =  readDatabase();
		return entity;
	}
	
	private ResponseEntity<?> readDatabase(){
		ResponseEntity<?> response;
		UserPrefList userPrefList = queryDB.getItemFromTable(2019);
		response = new ResponseEntity<UserPrefList>(userPrefList, HttpStatus.OK);
		return response;
	}
}
