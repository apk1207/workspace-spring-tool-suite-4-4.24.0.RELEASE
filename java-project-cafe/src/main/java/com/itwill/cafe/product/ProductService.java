package com.itwill.cafe.product;

import java.util.List;

/*
 * - 쇼핑몰 제품 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - UI(SWING,서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
public class ProductService {
	
	private ProductDao productDao;
	
	public ProductService() throws Exception {
		productDao = new ProductDao();
	}
	
	/*
	 * 전체상품보기
	 */
	public List<Product> productList() throws Exception{
			return productDao.selectAll();
	}
	/*
	 * 상품상세보기
	 */
	public Product productDetail(int p_no) throws Exception{
		return productDao.selectByNo(p_no);
	}
	
}
