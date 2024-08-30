package com.itwill.cafe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.cafe.common.DataSource;

public class UserDao {
	private DataSource datasouce;
	
	public UserDao() throws Exception {
		datasouce = new DataSource();
	}
	
	// User 테이블에 유저정보 추가
	public int insert(User user) throws Exception {
		
		// USER_INSERT = "insert into users(userid,password,name,phone,email) values(?,?,?,?,?)";
		Connection con = datasouce.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_INSERT);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getEmail());
		pstmt.executeUpdate();
		
		datasouce.close(con);
		
		
		return 0;
	}
	
	
	// User 테이블 회원정보 수정
	public int update(User user) throws Exception {
		
		//"update users set password = ?, name = ?, phone = ?, email = ? where userid = ?";
		Connection con = datasouce.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_UPDATE);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPhone());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, user.getUserId());
		pstmt.executeUpdate();
		
		datasouce.close(con);
		  
		return 0;
	}
}
