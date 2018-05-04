package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;


public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/commonservice.xml", "/config/userservice.xml" });
		
		UserService userService = (UserService)context.getBean("userServiceImpl");

		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setPassword(request.getParameter("password"));


		User dbUser = userService.loginUser(user);

		HttpSession session = request.getSession();
		
		session.setAttribute("user", dbUser);
		session.setMaxInactiveInterval(3600);
		return "redirect:/index.jsp";
	}
}