package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;




public class AddUserAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
																	new String[] {	"/config/commonservice.xml",
																						"/config/userservice.xml" }
									                                  );
		
		UserService userService = (UserService)context.getBean("userServiceImpl");

		User user=new User();
		user.setUserId(request.getParameter("userId"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setSsn(request.getParameter("ssn"));
		user.setPhone(request.getParameter("phone"));
		user.setAddr(request.getParameter("addr"));
		user.setEmail(request.getParameter("email"));
		
		System.out.println("AddUserAction ::"+user);
		
		userService.insertUser(user);
		
		return "redirect:/user/loginView.jsp";
	}
}