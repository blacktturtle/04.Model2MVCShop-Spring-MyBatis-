package com.model2.mvc.service.user.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.dao.UserDao;

public class UserDaoImpl implements UserDao {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" + getClass()+ ".setSqlSession() Call.......");
		this.sqlSession = sqlSession;
	}
	
	 public UserDaoImpl() {
			System.out.println("::" + getClass()+" default Constructor Call.......");
		}

	@Override
	public int insertUser(User user) throws Exception {
		return sqlSession.insert("UserMapper.insertUser",user);
		
	}
	
	@Override
	public User loginUser(User user) throws Exception {
		
		return sqlSession.selectOne("UserMapper.findUser",user);
	}
	
	@Override
	public User findUser(String userId) throws Exception {
		return (User)sqlSession.selectOne("UserMapper.findUser",userId);		
	}

	@Override
	public List<User> getUserList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper.getUserList" , search);
		
	}

	@Override
	public int updateUser(User user) throws Exception {
		return sqlSession.update("UserMapper.updateUser",user);
		
	}

	@Override
	public int getTotalCount() throws Exception {
		
		return sqlSession.selectOne("UserMapper.getTotalCount");
	}

	@Override
	public List<User> makeCurrentPageSql(Search search) {
		return sqlSession.selectList("UserMapper.makeCurrentSql",search);
	}

	@Override
	public boolean checkDuplication(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



}
