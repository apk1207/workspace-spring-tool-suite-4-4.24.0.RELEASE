package com.itwill.address;

import java.util.List;

/*
 * - 주소록관리 비즈니스로직(업무)을 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스
 * - AdderssDao객체 를 이용해서 데이타에 접근하는 클래스
 */


public class AddressService {
	private AddressDao addressDao;
	
	public AddressService() throws Exception {
		addressDao=new AddressDao();
	}
	/*
	 * 주소록쓰기
	 */
	public int addressWrite(Address address) throws Exception{
		return addressDao.insert(address);
	} 
	/*
	 * 주소록수정
	 */
	public int addressUpdate(Address address) throws Exception{
		return addressDao.updateByNo(address);
	}
	/*
	 * 주소록상세보기(번호로1개)
	 */
	public Address addressDetail(int no)throws Exception{
		return addressDao.selectByNo(no);
	}
	/*
	 * 주소록전체보기
	 */
	public List<Address> addressList() throws Exception{
		return addressDao.selectAll();
	}
	/*
	 * 주소록삭제(번호로 1개)
	 */
	public int addressDelete(int no) throws Exception{
		return  addressDao.deleteByNo(no);
	}
	
}
