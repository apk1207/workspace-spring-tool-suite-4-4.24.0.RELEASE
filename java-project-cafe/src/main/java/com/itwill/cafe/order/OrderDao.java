package com.itwill.cafe.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.cafe.common.DataSource;
import com.itwill.cafe.product.Product;
import com.itwill.cafe.user.User;

public class OrderDao {
	
	private DataSource dataSource;
	
	public OrderDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Order order) throws Exception {
		// insert into orders(o_no, o_desc, o_date, o_price, userid) values(orders_o_no_seq.nextval,?,sysdate, ?, ?)
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1, order.getODesc());
			pstmt1.setInt(2, order.getOPrice());
			pstmt1.setString(3, order.getUser().getUserId());
			pstmt1.executeUpdate();
			
			for(OrderItem orderItem : order.getOrderItems()) {
				// insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,?,orders_o_no_SEQ.currval,?)
				pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
				pstmt2.setInt(1, orderItem.getOiQty());
				pstmt2.setInt(2, orderItem.getProduct().getPNo());
				pstmt2.executeUpdate();
			}
			con.commit();
		} finally {
			if(con!=null) {
				dataSource.close(con);
			}
		}
			
		return 0;
	}
	
	// 주문내역에서 한건만 삭제
	public int deleteByOrderNo(int orderNo) throws Exception {
		// delete from orders where o_no=?
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
		pstmt.setInt(1, orderNo);
		pstmt.executeUpdate();
			
		return 0;
	}
	
	// 유저의 주문내역에서 전체 삭제
	public int deleteByUserId(String userId) throws Exception {
		// delete from orders where userid=?
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
			
		return 0;
	}
	
	
	// 유저의 주문내역 조회
	public Order selectByUserId(String userId) throws Exception {
		// select * from orders where userid=?
		Order orderList = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			orderList = new Order().builder()
					.oNo(rs.getInt("o_no"))
					.oDesc(rs.getString("o_desc"))
					.oDate(rs.getDate("o_date"))
					.oPrice(rs.getInt("o_price"))
					.user(User.builder().userId(rs.getString("userid")).build())
					.build();
		}
		
		return orderList;
	}
		
	
	// 특정 주문번호의 상세 주문내역 조회
	public Order selectAllByOrderNo(int o_no) throws Exception {
		
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			/*
			 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
			 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
			 */
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_ALL_BY_O_NO);
			pstmt.setInt(1, o_no);
			rs = pstmt.executeQuery();
			/*
			  O_NO   O_DESC 	  O_DATE 	O_PRICE  USERID  OI_NO  OI_QTY O_NO P_NO 	P_IMAGE 				P_NAME 	 	P_DESC 											 P_PRICE    	
			  ---------- ---------------------------------------------------------------------------------------------------------------------------------------------------------------- 
			  1	아메리카노외2종	2024/09/03	12500	 user1		1	  1	 	1	  1		Americano.png			아메리카노	고품질 원두로 내린 에스프레소를 사용한 대표 메뉴	3500
			  1	아메리카노외2종	2024/09/03	12500	 user1		2	  1	 	1	  2		CaffeLatte.png			카페라떼	쓴맛이 덜하면서도 고소한 맛까지 느낄수 있는 커피	4500
			  1	아메리카노외2종	2024/09/03	12500	 user1		3	  1	 	1	  3		CaramelMacchiato.png	카라멜마끼아또	달달한 커피가 떙길 떄 추천!.					4500
			 */
			if (rs.next()) {
				order = Order.builder()
						.oNo(rs.getInt("o_no"))
						.oDesc(rs.getString("o_desc"))
						.oDate(rs.getDate("o_date"))
						.oPrice(rs.getInt("o_price"))
						.user(User.builder().userId(rs.getString("userid")).build())
						.build();;
				do {
					order.getOrderItems()
							.add(OrderItem.builder()
									.oiNo(rs.getInt("oi_no"))
									.oiQty(rs.getInt("oi_qty"))
									.order(Order.builder().oNo(rs.getInt("o_no")).build())
									.product(Product.builder().pNo(rs.getInt("p_no")).build())
									.build());
				} while (rs.next());
			}
			} finally {
				if (con != null) {
					con.close();
				}
			}
		
		
		
		
		
		return order;
	}
	
	
}

