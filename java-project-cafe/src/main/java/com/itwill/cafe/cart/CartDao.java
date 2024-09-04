package com.itwill.cafe.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.cafe.common.DataSource;
import com.itwill.cafe.product.Product;
import com.itwill.cafe.user.User;

public class CartDao {
	
	DataSource dataSource;
	
	public CartDao() throws Exception {
		dataSource = new DataSource();
	}
	
	
	// 장바구니에 상품 추가
	public int inserCart(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);
		
		pstmt.setInt(1, cart.getCartQty());
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
	public int updateByProductNo(String sUserId,int p_no,int cart_qty) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO);
			pstmt.setInt(1, cart_qty);
			pstmt.setString(2, sUserId);
			pstmt.setInt(3, p_no);
			pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				dataSource.close(con);
			}
		}
		return 0;
	}
	// 상품정보에서 장바구니 상품 수량 업데이트(매개변수 객체로 받을 경우)
	public int updateByProductNo(Cart cart) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO);
			pstmt.setInt(1, cart.getCartQty());
			pstmt.setString(2, cart.getUser().getUserId());
			pstmt.setInt(3, cart.getProduct().getPNo());
			pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				dataSource.close(con);
			}
		}
		return 0;
	}
	
	/*
	 * cart제품 존재여부
	 */
	public int countByProductNo(String sUserId,int p_no) throws Exception{
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_SELEACT_FIND_PRODUCT_NO);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return count;
	}
	
	
	// user1의 장바구니 리스트 상세 조회
	public List<Cart> findByUserId(String userid)throws Exception{
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_SELECT_BY_USERID);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			/*
			/*
			select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid='user1'
			
			  CART_NO   CART_QTY   USERID  P_NO 	P_NAME      P_PRICE    	P_IMAGE          P_DESC                                                                                                P_DESC                                                                                                                                                                                                   P_CLICK_COUNT
			---------- ---------- --------------------------------------------------------------------------
				1			2	    user1	 1	 Americano.png	아메리카노	고품질 원두로 내린 에스프레소를 사용한 대표 메뉴	3500
				2			1	 	user1	 2	 CaffeLatte.png	카페 라떼	쓴맛이 덜하면서도 고소한 맛까지 느낄수 있는 커피	4500
				3			4		user1	 5	 Lemonade.png	레모네이드	레몬의 상큼한 향이 일품.							2500
			*/   
			while(rs.next()) {
				cartList.add(Cart.builder()
							.cartNo(rs.getInt("cart_no"))
							.cartQty(rs.getInt("cart_qty"))
							.user(User.builder().
								  userId(rs.getString("userid"))
								  .build())
							.product(Product.builder()
									.pNo(rs.getInt("p_no"))
									.pName(rs.getString("p_name"))
									.pPrice(rs.getInt("p_price"))
									.pImage(rs.getString("p_image"))
									.pDesc(rs.getString("p_desc"))
									.build())
							.build());
			}
			
		}finally {
			/* 항상실행하는 블록*/
			if(con!=null) {
				dataSource.close(con);
			}
		}
		
		 return cartList;
		
	}
	
}
