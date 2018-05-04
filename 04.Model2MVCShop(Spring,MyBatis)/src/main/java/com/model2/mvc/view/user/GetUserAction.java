package com.model2.mvc.view.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;


public class GetUserAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
																	new String[] {	"/config/commonservice.xml",
																						"/config/userservice.xml" }
									                                  );
		
		UserService userService = (UserService)context.getBean("userServiceImpl");
		
		
		String userId=request.getParameter("userId");
		System.out.println("유저아이디 : " + userId);
		
		User user=userService.findUser(userId);
		
		request.setAttribute("user", user);
		
		return "forward:/user/getUser.jsp";
	}
	
	
	
}