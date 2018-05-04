package com.model2.mvc.service.user;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;

public interface UserService {
	
	public int insertUser(User user) throws Exception ;
	
	public User findUser(String userId) throws Exception;
	
	public User loginUser(User user) throws Exception;
	
	public List<User> getUserList(Search search) throws Exception;
	
	public int updateUser(User user) throws Exception;
	
	public int getTotalCount() throws Exception;
	
	public List<User> makeCurrentPageSql(Search search);

	public boolean checkDuplication(String userId) throws Exception;
}
