package com.itwill.cafe.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.cafe.cart.Cart;
import com.itwill.cafe.cart.CartDao;
import com.itwill.cafe.product.Product;
import com.itwill.cafe.product.ProductDao;

public class OrderService {
	
	private OrderDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao;
	
	public OrderService() throws Exception {
		orderDao = new OrderDao();
		productDao = new ProductDao();
		cartDao = new CartDao();
	}
	
	/*
	 * 주문1개삭제
	 */
	public int deleteByOrderNo(int o_no)throws Exception{
		return orderDao.deleteByOrderNo(o_no);
	}
	
	/*
	* 주문전체삭제
	 */
	public int delete(String sUserId)throws Exception{
		return orderDao.deleteByUserId(sUserId);
	}
	
	/*
	 * 주문목록
	 */
	public List<Order> orderList(String sUserId) throws Exception{
		return orderDao.selectByUserId(sUserId);
	}
	
	/*
	 * 주문+주문아이템 상세보기
	 * 특정 주문번호의 상세 주문내역 보기
	 */
	public Order orderWithOrderItem(int o_no)throws Exception{
		return orderDao.selectAllByOrderNo(o_no);
	}
	
	/*
	 * 상품에서 직접주문
	 */
	
	/*
	 * cart에서 주문
	 */

	/*
	 * cart에서 선택주문
	 */
	
	
}
