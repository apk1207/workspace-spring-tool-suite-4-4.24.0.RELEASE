package com.itwill.cafe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.cafe.common.DataSource;

public class UserDao {
	private DataSource dataSource;
	
	public UserDao() throws Exception {
		dataSource = new DataSource();
	}
	
	// Users 테이블에 유저정보 추가
	public int insert(User user) throws Exception {
		
		// USER_INSERT = "insert into users(userid,password,name,phone,email) values(?,?,?,?,?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_INSERT);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getEmail());
		pstmt.executeUpdate();
		
		dataSource.close(con);
		
		
		return 0;
	}
	
	
	// Users 테이블 회원정보 수정
	public int update(User user) throws Exception {
		
		//"update users set password = ?, name = ?, phone = ?, email = ? where userid = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_UPDATE);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPhone());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, user.getUserId());
		pstmt.executeUpdate();
		
		dataSource.close(con);
		  
		return 0;
	}
	
	
	// Users 테이블 회원정보 삭제
	public int delete(String userId) throws Exception {
		// delete from users where userid = ?;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_DELETE); 
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		
		dataSource.close(con);
		
		return 0;
	}
	
	// Users 테이블 회원 한명 정보 출력
	public User selectById(String userId) throws Exception {
		
		User selectUser = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_SELECT); 
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			selectUser = new User(
						rs.getString("userid"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("email")
					);
			System.out.println(selectUser);
		}
		
		dataSource.close(con);
		
		return selectUser;
	}
	
}
