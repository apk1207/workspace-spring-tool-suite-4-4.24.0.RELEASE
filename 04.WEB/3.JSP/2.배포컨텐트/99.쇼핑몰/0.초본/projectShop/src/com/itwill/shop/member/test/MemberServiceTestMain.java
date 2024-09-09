package com.itwill.shop.member.test;

import com.itwill.shop.member.MemberService;

public class MemberServiceTestMain {

	public static void main(String[] args) throws Exception {
		MemberService memberService=new MemberService();
		System.out.println(memberService.list());
		System.out.println(memberService.detail(1));

	}

}
