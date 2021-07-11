package com.petpet.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.petpet.bean.EventBean;

@Controller
public class EventControllerSpring {
	
	@Autowired
	private IEventService EventService;
	
	@RequestMapping(path="/queryallevent.controller", method = {RequestMethod.POST,RequestMethod.GET})
	public String listAllEvents(Model m) {
		List<EventBean> event = EventService.queryall();
		m.addAttribute("events", event);
		return 	"event/getallevent";
	}
	
	@RequestMapping(path="/queryevent.controller", method = RequestMethod.GET)
	public String listEvent(@RequestParam("eventid") int eventid,Model m) {
		EventBean event = EventService.query(eventid);
		m.addAttribute("events", event);
		return 	"event/getaevent";
	}
	
	@RequestMapping(path="/addevent.controller", method = RequestMethod.POST)
	public String addEvent(HttpServletRequest request, Model m) {
		EventBean eventbean = new EventBean();
		eventbean.setEventName((String)(request.getParameter("eventname")));
		eventbean.setEventDate((String)(request.getParameter("eventdate")));
		eventbean.setEventStratTime((String)(request.getParameter("eventstarttime")));
		eventbean.setEventEndTime((String)(request.getParameter("eventendtime")));
		eventbean.setEventLocation((String)(request.getParameter("eventlocation")));
		eventbean.setEventType((String)(request.getParameter("eventtype")));
		eventbean.setEventType1((String)(request.getParameter("eventtype1")));
		eventbean.setEventType2((String)(request.getParameter("eventtype2")));
		eventbean.setEventTypeCustom((String)(request.getParameter("eventtypecustom")));
		eventbean.setEventMaxLimit(Integer.parseInt(request.getParameter("eventmaxlimit")));
		eventbean.setEventFee(Integer.parseInt(request.getParameter("eventfee")));
		eventbean.setEventDescribe((String)(request.getParameter("eventdescribe")));
		EventService.insert(eventbean);
		m.addAttribute("event",eventbean);
		return "event/correct";
	}
	@RequestMapping(path="/deleteevent.controller", method = RequestMethod.GET)
	public String deleteEvent(HttpServletRequest request, Model m) {
		int eventid =Integer.parseInt(request.getParameter("eventid"));
		EventBean eventbean = EventService.delete(eventid);
		m.addAttribute("event",eventbean);
		return "event/deletecorrect";
	}
	
	@RequestMapping(path="/modifyevent.controller", method = RequestMethod.GET)
	public String updateEvent(HttpServletRequest request, Model m) {
		EventBean eventbean = new EventBean();
		eventbean.setEventID(Integer.parseInt(request.getParameter("eventid")));
		eventbean.setEventName((String)(request.getParameter("eventname")));
		eventbean.setEventDate((String)(request.getParameter("eventdate")));
		eventbean.setEventStratTime((String)(request.getParameter("eventstarttime")));
		eventbean.setEventEndTime((String)(request.getParameter("eventendtime")));
		eventbean.setEventLocation((String)(request.getParameter("eventlocation")));
		eventbean.setEventType((String)(request.getParameter("eventtype")));
		eventbean.setEventType1((String)(request.getParameter("eventtype1")));
		eventbean.setEventType2((String)(request.getParameter("eventtype2")));
		eventbean.setEventTypeCustom((String)(request.getParameter("eventtypecustom")));
		eventbean.setEventMaxLimit(Integer.parseInt(request.getParameter("eventmaxlimit")));
		eventbean.setEventFee(Integer.parseInt(request.getParameter("eventfee")));
		eventbean.setEventDescribe((String)(request.getParameter("eventdescribe")));
		EventBean modifyeventbean = EventService.update(eventbean);
		m.addAttribute("event",modifyeventbean);
		return "event/correct";
	}
	@RequestMapping(path="/createeevent.url", method = RequestMethod.GET)
	public String creatEvent(HttpServletRequest request ) {

		return "event/createvent";
	}
}
