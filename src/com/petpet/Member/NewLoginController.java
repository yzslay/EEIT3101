package com.petpet.Member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.petpet.bean.LoginBean;

@Controller
public class NewLoginController {
	
	@Autowired
	private ILoginBeanService loginBeanService;
	
	
	@RequestMapping(path="/newCheckMemberData.controller", method = RequestMethod.POST)
	public String checkMemberData(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, HttpServletRequest request, Model m) {

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		boolean checkStatus = loginBeanService.checkLogin(new LoginBean(email, password));

		if (checkStatus) {
			m.addAttribute("email", email);
			m.addAttribute("password", password);
			
			LoginBean result = loginBeanService.selectByEmail(email);
			request.getSession().setAttribute("login", result.getMemberid());
			
			m.addAttribute("member", result);
			
			return "NewShowLogin";
		}

		errors.put("message", "please input correct username and password");
		return "Login";
	}
	
	@RequestMapping(path="/newGetMemberLogin.controller", method = RequestMethod.POST)
	public String getMemberLogin(@RequestParam(name = "memberid") String memberid, Model m) {
		
		LoginBean result = loginBeanService.selectById(memberid);
		m.addAttribute("member", result);
		
		return "NewMemberShow";
	}
	
	@RequestMapping(path="/newUpdateData.controller", method = RequestMethod.POST)
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
		
		return "NewShowLogin";
	}
	
	@RequestMapping(path="/newRegistermember.controller", method = RequestMethod.POST)
	public String registermember(@RequestParam(name = "email") String email, 
								 @RequestParam(name = "password") String password, Model m) {
		
		LoginBean insertbean = new LoginBean();
		insertbean.setEmail(email);
		insertbean.setPassword(password);
		LoginBean result = loginBeanService.insert(insertbean);
		m.addAttribute("member", result);
		
		return "NewShowLogin";

	}
	
	@RequestMapping(path="/newLogout.controller", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		if(request.getSession().getAttribute("login")!=null) {
			request.getSession().invalidate();
		}
		return "NewLogin";
	}

}
