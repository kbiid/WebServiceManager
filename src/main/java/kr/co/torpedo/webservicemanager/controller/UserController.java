package kr.co.torpedo.webservicemanager.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.torpedo.webservicemanager.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		logger.info("register");
		return "register";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") int id, Model model) {
		logger.info("detail");
		model.addAttribute("User", userService.selectUser(id));
		return "detail";
	}
}
