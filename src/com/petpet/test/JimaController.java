package com.petpet.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JimaController {
	
	@RequestMapping(path="/jima.controller", method = RequestMethod.GET)
	public String formAction(@RequestParam(name="userName") String username, Model m) {
		
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(username == null || username.length() == 0) {
			errors.put("username", "False");
		}
		if(errors != null && !errors.isEmpty()) {
			return "jimaTest";
		}
		
		m.addAttribute("user", username);
		return "success";
		
		
		
	}
	
	
	
	
}
