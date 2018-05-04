package com.model2.mvc.view.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;


public class ListUserAction extends Action {

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/commonservice.xml", "/config/userservice.xml" });
		
		UserService userService = (UserService)context.getBean("userServiceImpl");

		Search search=new Search();
		
		int currentPage=1;

		if(request.getParameter("currentPage") != null){
			if(!request.getParameter("currentPage").equals("")) {
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		
		search.setCurrentPage(currentPage);
		search.setSearchCondition(request.getParameter("searchCondition"));
		search.setSearchKeyword(request.getParameter("searchKeyword"));
		
		// web.xml  meta-data 로 부터 상수 추출 
		int pageSize = Integer.parseInt( getServletContext().getInitParameter("pageSize"));
		int pageUnit  =  Integer.parseInt(getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		
		
		search.setRowNum(search.getCurrentPage()*search.getPageSize());
		search.setBetween1((search.getCurrentPage()-1)*search.getPageSize()+1);
		search.setBetween2(search.getCurrentPage()*search.getPageSize());
		
		System.out.println("서치한번 출력 : " + search);
		
		// Business logic 수행
		List<User> list=userService.makeCurrentPageSql(search);
		
		for (User user : list) {
			System.out.println("유저한번 출력해보자 : " + user);	
		}
		
		
		int totalCount = userService.getTotalCount();
		System.out.println("토탈카운트 몇 ? " + totalCount);
		
		Page resultPage	= 
					new Page( currentPage, totalCount, pageUnit, pageSize);
		System.out.println("ListUserAction ::"+resultPage);
		
		// Model 과 View 연결
		//request.setAttribute("list", map.get("list"));
		request.setAttribute("list", list);
		request.setAttribute("resultPage", resultPage);
		request.setAttribute("search", search);
		
		return "forward:/user/listUser.jsp";
	}
}