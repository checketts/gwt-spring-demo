package com.github.checketts.controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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
	public String home() throws JsonGenerationException, JsonMappingException, IOException {
	    	logger.info("requesting home");
		return new AutoBeanMapper().writeValueAsString(new ListWrapper<Event>(eventService.getAllEvents()));
	}
}

