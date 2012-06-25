package com.github.checketts.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.checketts.model.Event;
import com.github.checketts.service.EventService;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class.getName());
	@Autowired EventService eventService;
	
	@RequestMapping(value="/events", method=RequestMethod.GET)
	@ResponseBody
	public List<Event> home() {
	    	logger.info("requesting home");
		return eventService.getAllEvents();
	}
}

