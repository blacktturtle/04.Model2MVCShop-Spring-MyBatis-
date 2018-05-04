package com.model2.mvc.service.user.impl;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.dao.UserDao;

import com.model2.mvc.service.domain.User;


public class UserServiceImpl implements UserService{
	
	///Field
	UserDao userDao;	

	public void setUserDao(UserDao userDao) {
		System.out.println("::" + getClass()+ ".setSqlSession() Call.......");
		this.userDao = userDao;
	}
	
	
	public UserServiceImpl() {
		System.out.println("::" + getClass()+" default Constructor Call.......");
	}
	
	@Override
	public int insertUser(User user) throws Exception {
		return userDao.insertUser(user);
	}
	
	@Override
	public User loginUser(User user) throws Exception {
		User dbUser=userDao.findUser(user.getUserId());
		if(! dbUser.getPassword().equals(user.getPassword())){
			throw new Exception("로그인에 실패했습니다.");
		}
		
		return dbUser;
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userDao.findUser(userId);
	}

	@Override
	public List<User> getUserList(Search search) throws Exception {
		return userDao.getUserList(search);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public int getTotalCount() throws Exception {
		return userDao.getTotalCount();
	}

	@Override
	public List<User> makeCurrentPageSql(Search search) {
		return userDao.makeCurrentPageSql(search);
	}
	
	public boolean checkDuplication(String userId) throws Exception {
		boolean result=true;
		User user=userDao.findUser(userId);
		if(user != null) {
			result=false;
		}
		return result;
	}


}