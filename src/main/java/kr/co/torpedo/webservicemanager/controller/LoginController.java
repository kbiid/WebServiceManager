package kr.co.torpedo.webservicemanager.controller;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.torpedo.webservicemanager.domain.Admin;
import kr.co.torpedo.webservicemanager.domain.Criteria;
import kr.co.torpedo.webservicemanager.domain.PageMaker;
import kr.co.torpedo.webservicemanager.domain.User;
import kr.co.torpedo.webservicemanager.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private ConfigReader reader;
	private Admin admin;

	@Inject
	private UserService userService;

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
	public String home() {
		logger.info("home method");
		return "login";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String checkInput(HttpServletRequest httpServletRequest, Model model, @ModelAttribute("cri") Criteria cri)
			throws NoSuchAlgorithmException {
		logger.info("checkInput");
		String id = httpServletRequest.getParameter("inputId");
		String passwd = httpServletRequest.getParameter("passwd");
		if (this.admin.checkAdminInfo(id, passwd)) {
			logger.info("login success");
			for (User user : userService.listCriteria(cri)) {
				logger.info(user.getFirstName() + ", " + user.getLastName()+ ", " + user.getIpAddress());
			}
			model.addAttribute("list", userService.listCriteria(cri));
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(userService.countPaging(cri));

			model.addAttribute("pageMaker", pageMaker);
			return "viewUserList";
		}
		logger.info("login fail");
		return "loginFail";
	}

}
