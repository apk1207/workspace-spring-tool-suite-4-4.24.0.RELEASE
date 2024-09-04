package com.itwill.cafe.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itwill.cafe.product.Product;
import com.itwill.cafe.user.User;

class CartDaoTest {
	CartDao cartDao;
	
	@BeforeEach
	void setUp() throws Exception {
		cartDao = new CartDao();
		assertNotNull(cartDao);
	}

	//@Test
	void testInserCart() throws Exception {
		// insert into cart(cart_no, cart_qty, p_no, userid) values(cart_cart_no_seq.nextval, ?, ?, ?)
		Cart cart = Cart.builder()
				.cartQty(4)
				.product(Product.builder().pNo(2).build())
				.user(User.builder().userId("user2").build())
				.build();
		cartDao.inserCart(cart);
	}

	//@Test
	void testDeleteByCartNo() throws Exception {
		// delete from cart where cart_no = ?
		int deleteNo = 5;
		cartDao.deleteByCartNo(deleteNo);
	}

	//@Test
	void testDeleteByUserId() throws Exception {
		// delete from cart where userid = ?
		String deleteUserId = "user2";
		cartDao.deleteByUserId(deleteUserId);
		
	}

	
	// 장바구니에서 상품수량 변경
	//@Test
	void testUpdateByCartNo() throws Exception {
		// update cart set cart_qty = ? where cart_no=?
		int addQTY = 3;
		int cart_no = 3;
		cartDao.updateByCartNo(addQTY, cart_no);
	}

	//@Test
	void testUpdateByProductNoStringIntInt() throws Exception {
		// update cart set cart_qty=cart_qty+? where userid=? and p_no=?
		String userId = "user1";
		int cartQty = 2;
		int p_no = 5;
		
		cartDao.updateByProductNo(userId, p_no, cartQty);
		
	}

	//@Test
	void testUpdateByProductNoCart() throws Exception {
		// update cart set cart_qty=cart_qty+? where userid=? and p_no=?
		Cart updateCart = Cart.builder()
									.cartQty(5)
									.user(User.builder().userId("user1").build())
									.product(Product.builder().pNo(5).build())
									.build();
		cartDao.updateByProductNo(updateCart);
	}

	//@Test
	void testCountByProductNo() throws Exception {
		String userId = "user1";
		int pNo = 2;
		int count = cartDao.countByProductNo(userId, pNo);
		System.out.println(count);
		
	}

	//@Test
	void testFindByUserId() throws Exception {
		String userId = "user1";
		List<Cart> selectList = new ArrayList<Cart>();
		selectList = cartDao.findByUserId(userId);
		System.out.println(selectList);
		
	}

}
