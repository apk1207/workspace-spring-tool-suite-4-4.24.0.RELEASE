package com.itwill.shop.product;

public class ProductSQL {
	/*
	--상품리스트
	select * from product;
	--상품상세보기
	select * from product where p_no=1;
	 */
	public static final String PRODUCT_SELECT_ALL=
			"select * from product";
	public static final String PRODUCT_SELECT_BY_NO=
			"select * from product where p_no=?";
	
}