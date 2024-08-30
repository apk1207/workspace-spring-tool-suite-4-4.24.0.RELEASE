package com.itwill.cafe.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
desc users;
이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(100) 
PASSWORD          VARCHAR2(100) 
NAME              VARCHAR2(100) 
PHONE             VARCHAR2(100) 
EMAIL             VARCHAR2(200) 
 */
class UserServiceTest {
	
	UserService userService;
	
	@BeforeEach
	void setUp() throws Exception {
		userService = new UserService();
		assertNotNull(userService);
	}

	//@Test
	void testAddUser() throws Exception {
		User newUser = new User().builder()
				.userId("user5")
				.password("555")
				.name("신짱구")
				.phone("555-5555")
				.email("555@5555")
				.build();
		
		userService.addUser(newUser);
	}

	@Test
	void testUpdate() throws Exception {
		User updateUser = new User().builder()
				.userId("user3")
				.password("777")
				.name("변경1")
				.phone("010-1111")
				.email("test@test")
				.build();
		
		userService.updateUser(updateUser);
	}
	
}
