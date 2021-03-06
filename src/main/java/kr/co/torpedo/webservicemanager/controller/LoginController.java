package kr.co.torpedo.webservicemanager.controller;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		logger.info("home method");
		if (session.getAttribute("Admin") != null) {
			logger.info("session Already exist");
			session.removeAttribute("Admin");
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkInput(HttpSession session, HttpServletRequest httpServletRequest, Model model)
			throws NoSuchAlgorithmException {
		logger.info("checkInput");
		if (this.admin.checkAdminInfo(httpServletRequest.getParameter("inputId"),
				httpServletRequest.getParameter("passwd"))) {
			logger.info("login success And make session");
			session = httpServletRequest.getSession(true);
			session.setAttribute("Admin", admin);
			return "redirect:/list";
		}
		logger.info("login fail");
		return "loginFail";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest httpServletRequest, Model model) throws NoSuchAlgorithmException {
		logger.info("logout");
		HttpSession session = httpServletRequest.getSession();
		if (session.getAttribute("Admin") != null) {
			logger.info("remove session");
			session.invalidate();
		}
		return "redirect:/";
	}
}
