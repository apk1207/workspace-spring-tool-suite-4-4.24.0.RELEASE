package com.itwill.cafe.user;

public class UserSQL {
	
	public static final String USER_INSERT = "insert into userinfo(userid,password,name,phone,email) values(?,?,?,?,?)";
	public static final String USER_UPDATE = "update users set password = ?, name = ?, phone = ?, email = ? where userid = ?";
	
	
	
	
	
	
	
}
