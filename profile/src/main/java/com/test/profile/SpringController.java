package com.test.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

	@Value("${spring.application.name:SpringTesT}")
	private String name;
	
	   @GetMapping("/hello-world-SpringController")
	   @ResponseBody
	public String callJson(@RequestParam(name="name",required=false) String name) {
	return "SpringController";
		
	}
	   
	   
}
