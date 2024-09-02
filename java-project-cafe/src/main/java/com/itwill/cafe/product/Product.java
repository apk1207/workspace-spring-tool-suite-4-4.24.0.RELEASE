package com.itwill.cafe.product;
/*
이름      널?       유형            
------- -------- ------------- 
P_NO    NOT NULL NUMBER(10)    
P_IMAGE          VARCHAR2(100) 
P_NAME           VARCHAR2(50)  
P_DESC           VARCHAR2(100) 
P_PRICE          NUMBER(10)  
 */

import com.itwill.cafe.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// getter, setter, toString, equals 등의 어노테이션들이 포함되어 함꼐 생성
@AllArgsConstructor		// 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@NoArgsConstructor		// 매개변수가 없는 기본 생성자를 자동으로 생성
@Builder				// 빌더 패턴에 따라 객체를 생성할 수 있는 메소드를 자동으로 생성

public class Product {
	private int pNo;
	private String pImage;
	private String pName;
	private String pDesc;
	private int pPrice;
}
