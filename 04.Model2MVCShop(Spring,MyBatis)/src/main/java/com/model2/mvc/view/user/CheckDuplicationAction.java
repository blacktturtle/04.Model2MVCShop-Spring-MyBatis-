package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.user.UserService;


public class CheckDuplicationAction extends Action{

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
																	new String[] {	"/config/commonservice.xml",
																						"/config/userservice.xml" }
									                                  );
		
		UserService userService = (UserService)context.getBean("userServiceImpl");


		String userId=request.getParameter("userId");
		boolean result=userService.checkDuplication(userId);
		
		request.setAttribute("result",new Boolean(result) );
		request.setAttribute("userId", userId);
		
		return "forward:/user/checkDuplication.jsp";
	}
}