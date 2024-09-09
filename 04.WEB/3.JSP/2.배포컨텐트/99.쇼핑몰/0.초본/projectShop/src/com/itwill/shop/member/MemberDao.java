package com.itwill.shop.member;

import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MemberDao {
	private DataSource dataSource;

	public MemberDao() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("db.properties"));
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}

	public ArrayList<Member> list() {
		ArrayList<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member(1, "KIM", "동서울"));
		memberList.add(new Member(2, "GIM", "서서울"));
		memberList.add(new Member(3, "SIM", "남서울"));
		return memberList;
	}

	public Member detail(int no) {
		return new Member(no, "김","CA");
	}

}
