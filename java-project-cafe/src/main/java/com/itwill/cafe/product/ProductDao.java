package com.itwill.cafe.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.cafe.common.DataSource;

public class ProductDao {
	private DataSource dataSource;
	
	public ProductDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public Product selectByNo(int no) throws Exception {
		Product selectProduct = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			selectProduct = new Product(
					rs.getInt("p_no"),
					rs.getString("p_image"),
					rs.getString("p_name"),
					rs.getString("p_desc"),
					rs.getInt("p_price")
					);
			System.out.println(selectProduct);
		}
		
		dataSource.close(con);
		
		return selectProduct;
	}
	
	
	public List<Product> selectAll() throws Exception {
		List<Product> selectList = new ArrayList<Product>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Product product = new Product(
					rs.getInt("p_no"),
					rs.getString("p_image"),
					rs.getString("p_name"),
					rs.getString("p_desc"),
					rs.getInt("p_price")
					);
			System.out.println(product);
			selectList.add(product);
		}
		
		dataSource.close(con);
		
		return selectList;
	}
	
	
}
