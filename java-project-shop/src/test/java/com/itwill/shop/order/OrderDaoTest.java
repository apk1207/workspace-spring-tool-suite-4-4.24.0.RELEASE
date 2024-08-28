package com.itwill.shop.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderDaoTest {
    OrderDao orderDao;
	@BeforeEach
	void setUp() throws Exception {
		orderDao=new OrderDao();
	}

	@Test
	void testFindOrderWithOrderItemByUserId() throws Exception {
		List<Order> orderList = orderDao.findOrderWithOrderItemByUserId("guard1");
		assertEquals(2, orderList.size());
		assertEquals(3, orderList.get(0).getOrderItems().size());
		assertEquals(3, orderList.get(1).getOrderItems().size());
		for (Order order : orderList) {
			System.out.println("----------"+order.getO_no()+"--------------");
			for (OrderItem orderItem : order.getOrderItems()) {
				System.out.println(orderItem);
			}
		}
	}

}