package kr.co.torpedo.webservicemanager.controller;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.torpedo.webservicemanager.domain.Admin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private ConfigReader reader;
	private Admin admin;

	// 초기화를 위한 작업
	@PostConstruct
	public void init() {
		logger.info("controller init");
		reader = new ConfigReader();
		admin = new Admin();
		admin.setId(reader.getAdminId());
		admin.setPasswd(reader.getAdminPwd());
	}

	@RequestMapping(value = "/")
	public String home() {
		logger.info("home method");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkInput(Admin admin, Model model) throws NoSuchAlgorithmException {
		logger.info("checkInput method");
		if (this.admin.checkAdminInfo(admin.getId(), admin.getPasswd())) {
			return "viewUserList";
		}
		return "loginFail";
	}
}
