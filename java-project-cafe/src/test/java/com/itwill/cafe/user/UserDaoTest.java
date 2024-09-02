package com.itwill.cafe.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itwill.cafe.common.DataSource;

class UserDaoTest {
	UserDao userDao;
	
	@BeforeEach
	void setUp() throws Exception {
		userDao = new UserDao();
		assertNotNull(userDao);
	}
	
	// 회원정보 추가 테스트
	//@Test
	void testInsert() throws Exception {
		User insertUser = new User().builder()
				.userId("user4")
				.password("qqq")
				.name("유저4")
				.phone("777-7777")
				.email("777@777")
				.build();
		
		userDao.insert(insertUser);
		
	}
	
	// 회원정보 업데이트 테스트
	//@Test
	void testUpdate() throws Exception {
		User updateUser = new User().builder()
				.userId("user3")
				.password("update")
				.name("업뎃유저")
				.phone("000-0000")
				.email("000@000")
				.build();
		
		userDao.update(updateUser);
	}
	
	// 회원정보 삭제 테스트
	/* cart 테이블에 해당 유저가 담은 주문정보가 있으면 삭제불가 */
	//@Test
	void testDelete() throws Exception {
		String deleteUser = "user1";
		userDao.delete(deleteUser);

	}

	
	// 한명의 회원정보 조회 테스트
	//@Test
	void testSelectById() throws Exception {
		String selectuserId = "user2";
		userDao.selectById(selectuserId);
	}
	
	

}
