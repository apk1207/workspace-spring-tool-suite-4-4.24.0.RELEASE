package com.itwill.cafe.cart;

import com.itwill.cafe.product.Product;
import com.itwill.cafe.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 장바구니 테이블
/*
이름       널?       유형            
-------- -------- ------------- 
CART_NO  NOT NULL NUMBER(10)    PK
CART_QTY          NUMBER(10)    
P_NO              NUMBER(10)    FK
USERID            VARCHAR2(100) FK
 */

@Data					// getter, setter, toString, equals 등의 어노테이션들이 포함되어 함꼐 생성
@AllArgsConstructor		// 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@NoArgsConstructor		// 매개변수가 없는 기본 생성자를 자동으로 생성
@Builder				// 빌더 패턴에 따라 객체를 생성할 수 있는 메소드를 자동으로 생성
public class Cart {
	
	private int cartNo;
	private int cartQty;
	
	/***********FK***********/
	private Product product;	// p_no
	private User user;			// userid
	
	
}
