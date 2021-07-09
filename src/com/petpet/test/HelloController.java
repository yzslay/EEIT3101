package com.petpet.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping(path = "/test",method = RequestMethod.GET)
	public String testMainPage() {
		return "test";
	}
	
	@RequestMapping(path = "/test.controller",method = RequestMethod.GET)
	public String test(@RequestParam("name") String name,Model m) {
		Map<String,String> errors = new HashMap<String,String>();
		m.addAttribute("errors", errors);
		if(name==null || name.length()==0) {
			errors.put("name","name is required");
		}
		m.addAttribute("name", name);
		return "test";
	}

}
