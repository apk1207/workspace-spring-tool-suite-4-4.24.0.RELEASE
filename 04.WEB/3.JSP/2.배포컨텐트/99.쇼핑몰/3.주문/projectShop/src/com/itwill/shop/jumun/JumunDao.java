package com.itwill.shop.jumun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

public class JumunDao {
	
	private DataSource dataSource;
	public JumunDao() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/db.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}
	/*
	 * 주문삭제
	 */
	public int delete(int j_no)throws Exception{
		/*
		 delete from jumun_detail where j_no=1;
		 delete from jumun where j_no=1;
		 */
		String deleteSql1="delete from jumun_detail where j_no=?";
		String deleteSql2="delete from jumun where j_no=?";
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(deleteSql1);
			pstmt2=con.prepareStatement(deleteSql2);
			pstmt1.setInt(1, j_no);
			pstmt2.setInt(1, j_no);
			int rowCount1 = pstmt1.executeUpdate();
			int rowCount2 = pstmt2.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
			
		}
		return 0;
		
	}
	
	
	/*
	 * 주문생성
	 */
	public int create(Jumun jumun) throws Exception{
		/*
		insert into jumun(j_no,j_desc,j_date,j_price,userid) values (jumun_j_no_SEQ.nextval,'비글외1종',sysdate-2,1050000,'guard1');
		insert into jumun_detail(jd_no,jd_qty,j_no,p_no) values(jumun_detail_jd_no_SEQ.nextval,1,jumun_j_no_SEQ.currval,1);
		*/
		String insertJumun=
		"insert into jumun(j_no,j_desc,j_date,j_price,userid) values (jumun_j_no_SEQ.nextval,?,sysdate,?,?)";
		String insertJumunDetail=
		"insert into jumun_detail(jd_no,jd_qty,j_no,p_no) values(jumun_detail_jd_no_SEQ.nextval,?,jumun_j_no_SEQ.currval,?)";
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=dataSource.getConnection();
			
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(insertJumun);
			pstmt1.setString(1, jumun.getJ_desc());
			pstmt1.setInt(2, jumun.getJ_price());
			pstmt1.setString(3, jumun.getUserId());
			pstmt1.executeUpdate();
			
			pstmt2=con.prepareStatement(insertJumunDetail);
			for(JumunDetail jumunDetail:jumun.getJumunDetailList()) {
				pstmt2.setInt(1, jumunDetail.getJd_qty());
				pstmt2.setInt(2, jumunDetail.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}
	
	
	/*
	 * 주문전체(특정사용자)
	 */
	public ArrayList<Jumun> list(String sUserId) throws Exception{
		ArrayList<Jumun> jumunList=new ArrayList<Jumun>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from jumun where userid=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jumunList.add(new Jumun(rs.getInt("j_no"),
										rs.getString("j_desc"),
								       rs.getDate("j_date"),
								       rs.getInt("j_price"),
								       rs.getString("userid"),
								       null));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return jumunList;
	}
	/*
	 * 주문1개보기(주문상세리스트)
	 */
	public Jumun detail(String sUserId,int j_no)throws Exception{
		String selectSql=
"select * from jumun j join jumun_detail jd on j.j_no=jd.j_no  join  product p on jd.p_no=p.p_no where j.userid=? and j.j_no = ?";
		Jumun jumun=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(selectSql);
		pstmt.setString(1,sUserId);
		pstmt.setInt(2,j_no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			jumun=new Jumun(rs.getInt("j_no"), 
					rs.getString("j_desc"),
					rs.getDate("j_date"),
					rs.getInt("j_price"),rs.getString("userid"));
			do {
				jumun.getJumunDetailList()
					.add(new JumunDetail(
								rs.getInt("jd_no"), 
								rs.getInt("jd_qty"), 
								rs.getInt("j_no"), 
								new Product(rs.getInt("p_no"),
											rs.getString("p_name"),
											rs.getInt("p_price"),
											rs.getString("p_image"),
											rs.getString("p_desc"),
											rs.getInt("p_click_count"))
								)
							);
			}while(rs.next());
		}
		
		
		return jumun;
	}
	
	
}
