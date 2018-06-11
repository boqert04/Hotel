package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BaseController {
	
	private static final String VIEW_INDEX = "index";
	private static int rooms_available = 10;
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Welcome");
		model.addAttribute("rooms available", rooms_available);
		logger.debug("[welcome] counter : {}", rooms_available);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		
		model.addAttribute("message", "Welcome" + name);
		model.addAttribute("rooms available", rooms_available);
		return VIEW_INDEX;
	}

}
