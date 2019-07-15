package kr.co.torpedo.webservicemanager.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.torpedo.webservicemanager.paging.Criteria;
import kr.co.torpedo.webservicemanager.paging.PageMaker;
import kr.co.torpedo.webservicemanager.service.UserService;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Inject
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest httpServletRequest) {
		logger.info("listPage");
		if (!checkSession(httpServletRequest)) {
			logger.info("Don't have session");
			return "redirect:/";
		}
		model.addAttribute("list", userService.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.countPaging(cri));

		model.addAttribute("pageMaker", pageMaker);

		return "viewUserList";
	}

	@RequestMapping(value = "/typography")
	public String board(HttpServletRequest httpServletRequest) {
		logger.info("board");
		if (!checkSession(httpServletRequest)) {
			logger.info("Don't have session");
			return "redirect:/";
		}
		return "typography";
	}

	@RequestMapping(value = "/widgets")
	public String info(HttpServletRequest httpServletRequest) {
		logger.info("widgets");
		if (!checkSession(httpServletRequest)) {
			logger.info("Don't have session");
			return "redirect:/";
		}
		return "widgets";
	}

	public boolean checkSession(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		if (session.getAttribute("Admin") == null) {
			return false;
		}
		return true;
	}
}
