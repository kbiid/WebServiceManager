package kr.co.torpedo.webservicemanager.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import kr.co.torpedo.webservicemanager.domain.User;
import kr.co.torpedo.webservicemanager.service.UserService;

@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

	@Inject
	private UserService userService;

	@RequestMapping(value = "/selectAllUser", method = RequestMethod.POST)
	public void getListByAjax(HttpServletRequest req, HttpServletResponse rep) throws IOException {
		logger.info("getList");
		List<User> userList = userService.selectAll();
		Gson gson = new Gson();
		String result = gson.toJson(userList);

		logger.info("send List");
		rep.setCharacterEncoding("UTF-8");
		rep.setContentType("text/html; charset=UTF-8");
		rep.getWriter().write(result);
	}
}
