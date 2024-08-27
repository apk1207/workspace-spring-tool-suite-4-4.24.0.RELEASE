package com.itwill.shop.cart;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

class CartDaoTest {
	CartDao cartDao;
	@BeforeEach
	void setUp() throws Exception {
		cartDao=new CartDao();
	}

	//@Test
	void testInsert() throws Exception{
		Cart cart=Cart.builder()
				.cart_qty(5)
				.user(User.builder().userId("guard1").build())
				.product(Product.builder().p_no(2).build())
				.build();
		
		int insertRowCount1 = cartDao.insert(cart);
		assertEquals(1, insertRowCount1);
		
		//int insertRowCount2 = cartDao.insert("guard2",1,3);
		//assertEquals(1, insertRowCount2);
		
	}
	//@Test
	void testUpdateByProductNo() throws Exception{
		Cart cart=Cart.builder()
				.cart_qty(3)
				.product(Product.builder().p_no(1).build())
				.user(User.builder().userId("guard1").build())
				.build();
		
		int updateRowCount=cartDao.updateByProductNo(cart);
		assertEquals(1, updateRowCount);
		
	}
	//@Test
	void testCountByProductNo() throws Exception{
		int pCount = cartDao.countByProductNo("guard1",1);
		assertTrue(pCount==1);
		pCount = cartDao.countByProductNo("guard1",7);
		assertTrue(pCount==0);
		
	}
	@Test
	void testFindByUserId() throws Exception {
		List<Cart> cartList=cartDao.findByUserId("guard1");
		System.out.println(cartList);
		for (Cart cart : cartList) {
			assertTrue(cart.getProduct().getP_no()>=1 && cart.getProduct().getP_no()<=8);
			//System.out.println(cart.getProduct());
			assertEquals("guard1",cart.getUser().getUserId());
			//System.out.println(cart.getUser());
		}
	}

}