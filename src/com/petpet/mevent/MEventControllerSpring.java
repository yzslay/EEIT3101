package com.petpet.mevent;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.petpet.bean.mevent.MarketingEventBean;

@Controller

public class MEventControllerSpring {
	private static final int EMPNO=1012;
	
	@Autowired
	private IMarketingEventService marketingEventService;
	
	@RequestMapping(path = "/mevent",method = {RequestMethod.GET,RequestMethod.POST})
	public String meventMainPage(@RequestParam(name="action",defaultValue = "list") String action,
			@RequestParam(name="pic",required = false) MultipartFile pic,
			HttpServletRequest request,Model m) throws IOException, ServletException {
		switch(action) {
		case "new":
            return "mevent/MEventForm";
        case "insert":
            return insertMEvent(pic,request,m);
        case "delete":
            return deleteMEvent(request,m);
        case "edit":
            return showEditForm(request,m);
        case "update":
            return updateMEvent(pic,request,m);
        case "search":
        	return "mevent/QueryMEvent";
        case "query":
        	return queryMEvent(request,m);
        default:
            return listMEvent(m);           
		}
		
	}
	
	private String updateMEvent(@RequestParam("pic") MultipartFile pic,HttpServletRequest request, Model m) throws IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");     
		Timestamp startdate = Timestamp.valueOf(request.getParameter("startdate")+" "+request.getParameter("starttime"));
		Timestamp enddate = Timestamp.valueOf(request.getParameter("enddate")+" "+request.getParameter("endtime"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int typeid =Integer.parseInt(request.getParameter("typeid"));
		int ownerid = EMPNO;
		boolean online = Boolean.valueOf(request.getParameter("online"));
        MarketingEventBean mevent = new MarketingEventBean();
        mevent.setMeventid(id);
        mevent.setMeventtitle(title);
        if(pic.isEmpty()) {
        	if(marketingEventService.selectById(id).getMeventpicture()==null) {mevent.setMeventpicture(null);
        	}else{mevent.setMeventpicture(marketingEventService.selectById(id).getMeventpicture());}
        }else {mevent.setMeventpicture(pic.getBytes());}
        mevent.setMeventstartdate(startdate);
        mevent.setMeventenddate(enddate);
        mevent.setMeventname(name);
        mevent.setMeventdescription(description);
        mevent.setMeventtypeid(typeid);
        mevent.setMeventownerid(ownerid);
        mevent.setMeventonline(online);    
        marketingEventService.update(mevent);
		return listMEvent(m);
	}

	private String insertMEvent(@RequestParam("pic") MultipartFile pic,HttpServletRequest request, Model m) throws IOException, ServletException {
		String title = marketingEventService.title();
		Timestamp startdate = Timestamp.valueOf(request.getParameter("startdate")+" "+request.getParameter("starttime"));
		Timestamp enddate = Timestamp.valueOf(request.getParameter("enddate")+" "+request.getParameter("endtime"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int typeid =Integer.parseInt(request.getParameter("typeid"));
		int ownerid = EMPNO;
		boolean online = Boolean.valueOf(request.getParameter("online"));
        MarketingEventBean mevent = new MarketingEventBean();
        mevent.setMeventtitle(title);
        if(pic.isEmpty()) {mevent.setMeventpicture(null);}else {mevent.setMeventpicture(pic.getBytes());}
        mevent.setMeventstartdate(startdate);
        mevent.setMeventenddate(enddate);
        mevent.setMeventname(name);
        mevent.setMeventdescription(description);
        mevent.setMeventtypeid(typeid);
        mevent.setMeventownerid(ownerid);
        mevent.setMeventonline(online);	
        marketingEventService.insert(mevent);
		return listMEvent(m);
	}

	private String deleteMEvent(HttpServletRequest request, Model m) {
		int eid=Integer.parseInt(request.getParameter("eid"));
		MarketingEventBean mevent = new MarketingEventBean();
	    mevent.setMeventid(eid);
	    marketingEventService.delete(mevent);
		return listMEvent(m);
	}

	private String showEditForm(HttpServletRequest request, Model m) {
		int eid = Integer.parseInt(request.getParameter("eid"));
		MarketingEventBean existingmevent = marketingEventService.selectById(eid);
		m.addAttribute("mevent", existingmevent);
		return "mevent/MEventForm";
	}

	private String queryMEvent(HttpServletRequest request,Model m) {
		String name="%"+request.getParameter("name")+"%";
		List<MarketingEventBean> mevents = marketingEventService.query(name);
		m.addAttribute("mevents", mevents);
		return "mevent/ListMEvent";
	}

	private String listMEvent(Model m) {
		List<MarketingEventBean> mevents = marketingEventService.selectAll();
		m.addAttribute("mevents", mevents);
		return "mevent/ListMEvent";
	}

}
