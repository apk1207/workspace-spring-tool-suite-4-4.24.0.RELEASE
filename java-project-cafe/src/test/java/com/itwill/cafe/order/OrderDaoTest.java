package com.itwill.cafe.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itwill.cafe.user.User;

class OrderDaoTest {
	OrderDao orderDao;
	
	@BeforeEach
	void setUp() throws Exception {
		orderDao = new OrderDao();
		assertNotNull(orderDao);
	}

	//@Test
	void testInsert() throws Exception {
		Order newOrder = new Order().builder()
				.oDesc("테스트인서트")
				.oPrice(12233)
				.user(new User().builder().userId("user1").build())
				.build();
		orderDao.insert(newOrder);
		
	}

	//@Test
	void testDeleteByOrderNo() throws Exception {
		int no = 4;
		orderDao.deleteByOrderNo(4);
	}

	// oder_item 테이블에 o_no값이 있으면 삭제 불가능함
	//@Test 
	void testDeleteByUserId() throws Exception {
		String userId = "user3";
		orderDao.deleteByUserId(userId);
	}

	//@Test
	void testSelectByUserId() throws Exception {
		String user = "user1";
		List<Order> orderList = orderDao.selectByUserId(user);
		System.out.println(orderList);
	}

	//@Test
	void testSelectAllByOrderNo() throws Exception{
		int no = 4;
		Order orderList = orderDao.selectAllByOrderNo(no);
		System.out.println(orderList);
		
	}

}
