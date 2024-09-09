package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoTestMain {
	public static void main(String[] args) throws Exception{
		GuestDao guestDao=new GuestDao();
		System.out.println("1.insert");
		System.out.println(guestDao.insertGuest(	
							new Guest(0, "name", null,
									"email@gmail.com", "http//www.naver.com",
									"타이틀", "컨텐트")));
		System.out.println("2.selectByNo");
		System.out.println(guestDao.selectByNo(1));
		System.out.println("3.updateGuest");
		Guest updateGuest=guestDao.selectByNo(4);
		updateGuest.setGuest_name("이름변경");
		updateGuest.setGuest_title("타이틀변경");
		updateGuest.setGuest_content("컨텐트변경");
		System.out.println(guestDao.updateGuest(updateGuest));
		System.out.println("4.deleteGuest");
		System.out.println(guestDao.deleteGuest(1));
		System.out.println("9.selectAll");
		System.out.println(guestDao.selectAll());

	}

}
