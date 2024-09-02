package com.itwill.cafe.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.cafe.common.DataSource;

public class CartDao {
	
	DataSource dataSource;
	
	public CartDao() throws Exception {
		dataSource = new DataSource();
	}
	
	
	// 장바구니에 상품 추가
	public int inserCart(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);
		
		pstmt.setInt(1, cart.getCartQTY());
		pstmt.setInt(2, cart.getProduct().getPNo());
		pstmt.setString(3, cart.getUser().getUserId());
		pstmt.executeUpdate();
		
		
		dataSource.close(con);
		
		return 0;
	}
	
	
	// 장바구니에서 "user1"이 담아놓은 상품 전체 삭제                                                                 
	public int deleteByUserId(String userId) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
		
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		 
		dataSource.close(con);
		
		return 0;
	}
	
	// 장바구니에서 특정 상품 삭제
	public int deleteByCartNo(int CartNo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
		
		pstmt.setInt(1, CartNo);
		pstmt.executeUpdate();
		
		dataSource.close(con);
		
		return 0;
	}
	
	
	// 장바구니에서 한 상품의 주문수량 변경
	public int updateByCartNo(int cartNo, int cartQTY) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
		
		pstmt.setInt(1, cartQTY);
		pstmt.setInt(2, cartNo);
		pstmt.executeUpdate();
		
		dataSource.close(con);
		
		return 0;
	}
	
	
	// 상품정보에서 장바구니 상품 수량 업데이트
	public int updateByProductNo() throws Exception {
		
		
		return 0;
	}
	
	
}
