package com.petpet.Member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.petpet.bean.LoginBean;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginBeanService loginBeanService;
	
	@RequestMapping(path="/checkMemberData.controller", method = RequestMethod.POST)
	public String checkMemberData(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, Model m) {

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		boolean checkStatus = loginBeanService.checkLogin(new LoginBean(email, password));

		if (checkStatus) {
			m.addAttribute("email", email);
			m.addAttribute("password", password);
			
			LoginBean result = loginBeanService.selectByEmail(email);
			m.addAttribute("member", result);
			
			return "ShowLogin";
		}

		errors.put("message", "please input correct username and password");
		return "Login";
	}
	
	@RequestMapping(path="/getMemberLogin.controller", method = RequestMethod.POST)
	public String getMemberLogin(@RequestParam(name = "memberid") String memberid, Model m) {
		
		LoginBean result = loginBeanService.selectById(memberid);
		m.addAttribute("member", result);
		
		return "MemberShow";
	}
	
	@RequestMapping(path="/updateData.controller", method = RequestMethod.POST)
	public String updateData(@RequestParam(name = "memberid") String memberid, HttpServletRequest request, Model m) {
		
		LoginBean loginBean = new LoginBean();
		loginBean.setFirstname(request.getParameter("firstname"));
		loginBean.setLastname(request.getParameter("lastname"));
		loginBean.setGender(request.getParameter("gender"));
		loginBean.setBirthday(request.getParameter("birthday"));
		loginBean.setMobile(request.getParameter("mobile"));
		loginBeanService.update(memberid, loginBean);
		LoginBean member = loginBeanService.selectById(memberid); 		
		m.addAttribute("member", member);
		
		return "ShowLogin";
	}
	
	@RequestMapping(path="/registermember.controller", method = RequestMethod.POST)
	public String registermember(@RequestParam(name = "email") String email, 
								 @RequestParam(name = "password") String password, Model m) {
		
		LoginBean insertbean = new LoginBean();
		insertbean.setEmail(email);
		insertbean.setPassword(password);
		LoginBean result = loginBeanService.insert(insertbean);
		m.addAttribute("member", result);
		
		return "ShowLogin";

	}

}
