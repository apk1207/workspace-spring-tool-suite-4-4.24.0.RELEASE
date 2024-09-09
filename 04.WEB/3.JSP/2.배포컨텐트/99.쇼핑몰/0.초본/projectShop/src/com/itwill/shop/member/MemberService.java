package com.itwill.shop.member;

import java.util.ArrayList;

public class MemberService {
	private MemberDao memberDao;
	public MemberService() throws Exception{
		memberDao=new MemberDao();
	}
	
	public ArrayList<Member> list(){
		return memberDao.list();
	}
	public Member detail(int no){
		return memberDao.detail(no);
	}
}
