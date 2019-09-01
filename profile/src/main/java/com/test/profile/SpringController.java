package com.test.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

	   @GetMapping("/hello-world")
	   @ResponseBody
	public SpringJsonReturn callJson(@RequestParam(name="name",required=false) String name) {
	return new SpringJsonReturn();
		
	}
}
