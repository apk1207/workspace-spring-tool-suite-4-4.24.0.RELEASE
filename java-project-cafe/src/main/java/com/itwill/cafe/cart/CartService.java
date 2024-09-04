package com.itwill.cafe.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	
	public CartService() throws Exception {
		cartDao = new CartDao();
	}
	
	/*
	 * 카트추가 or 수정
	 */
	public int addCart(Cart cart)throws Exception {
		if(cartDao.countByProductNo(cart.getUser().getUserId(), cart.getProduct().getPNo()) > 0) {
			return cartDao.updateByProductNo(cart);
		}else {
			return cartDao.inserCart(cart);
		}
	}
	
	/*
	 * 카트수량변경수정
	 */
	
	// 장바구니에서 수정
	public int updateCart(int cart_no,int cart_qty)throws Exception {
		return cartDao.updateByCartNo(cart_no, cart_qty);
	}
	
	// 상품정보에서 수정
	public int updateCart(Cart cart) throws Exception {
		return cartDao.updateByProductNo(cart);
	}
	
	/*
	 * 카트보기
	 */
	
	public List<Cart> findCartByUserId(String userId) throws Exception {
		
		return cartDao.findByUserId(userId);
	}
	
	/*
	 * 카트아이템1개삭제
	 */
	public int deleteCartItemByCartNo(int cart_no) throws Exception{
		return cartDao.deleteByCartNo(cart_no);
	}
	
	/*
	 * 카트삭제
	 */
	public int deleteCartItemByUserId(String sUserId)throws Exception {
		return cartDao.deleteByUserId(sUserId);
	}
	
}
