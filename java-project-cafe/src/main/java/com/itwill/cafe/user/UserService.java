package com.itwill.cafe.user;

import static org.junit.Assert.assertNotNull;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() throws Exception {
		userDao = new UserDao();
	}
	
	
	// 신규 회원정보 추가
	public void addUser(User user) throws Exception {
		userDao.insert(user);
		
	}
	
	public void updateUser(User user) throws Exception {
		userDao.update(user);
	}
	
}
