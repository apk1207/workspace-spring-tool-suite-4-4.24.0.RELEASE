package com.itwill.guest;

import java.util.ArrayList;

public class GuestService {
	private GuestDao guestDao;

	public GuestService() {
		this.guestDao = new GuestDao();
	}

	public int insertGuest(Guest guest) throws Exception {
		return guestDao.insertGuest(guest);
	}

	public Guest selectByNo(int no) throws Exception {
		return guestDao.selectByNo(no);
	}

	public ArrayList<Guest> selectAll() throws Exception {
		return guestDao.selectAll();
	}

	public int updateGuest(Guest guest) throws Exception {
		return guestDao.updateGuest(guest);
	}

	public int deleteGuest(int no) throws Exception {
		return guestDao.deleteGuest(no);
	}

}
