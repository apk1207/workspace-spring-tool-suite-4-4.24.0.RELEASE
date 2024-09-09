package com.itwill.shop.member;

public class Member {
	private int no;
	private String name;
	private String address;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + ", address=" + address + "]";
	}

	public Member(int no, String name, String address) {
		super();
		this.no = no;
		this.name = name;
		this.address = address;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
