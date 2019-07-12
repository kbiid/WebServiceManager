package kr.co.torpedo.webservicemanager.controller;

import javax.inject.Inject;

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
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model) {
		logger.info("listPage");
		model.addAttribute("list", userService.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.countPaging(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "viewUserList";
	}
}
