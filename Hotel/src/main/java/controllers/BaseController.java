package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import DAO.UserService;
import entitys.User;

@Controller
public class BaseController {
	
	private static final String VIEW_INDEX = "index";
	private static int rooms_available = 10;
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	private static int test=1;
	
	@Autowired
	private UserService userService ;

	@Autowired
	private User user;
	
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(ModelMap model) {
		user= userService.findByUsername("raul");
		model.addAttribute("message",user.getUsername());
		model.addAttribute("rooms available", rooms_available);
		model.addAttribute("test", test);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value="/Hotel", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		
		model.addAttribute("message", "Welcome" + name);
		model.addAttribute("rooms_available", rooms_available);
	
		return VIEW_INDEX;
	}

}
