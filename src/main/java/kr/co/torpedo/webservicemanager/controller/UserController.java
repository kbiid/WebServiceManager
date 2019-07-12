package kr.co.torpedo.webservicemanager.controller;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("id") int id, Model model) {
		logger.info("update");
		model.addAttribute("User", userService.selectUser(id));
		return "update";
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody Map<String, Object> params) {
		logger.info("delete");
		userService.delete(Integer.parseInt(params.get("id").toString()));
		logger.info("delete success");
		return "redirect:/list";
	}
}
