package com.itwill.cafe.order;
/*
이름     널?       유형         
------ -------- ---------- 
OI_NO  NOT NULL NUMBER(10) 	PK
OI_QTY          NUMBER(10) 
O_NO            NUMBER(10) 	FK
P_NO            NUMBER(10) 	FK
 */

import java.util.Date;

import com.itwill.cafe.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data					// getter, setter, toString, equals 등의 어노테이션들이 포함되어 함꼐 생성
@AllArgsConstructor		// 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@NoArgsConstructor		// 매개변수가 없는 기본 생성자를 자동으로 생성
@Builder				// 빌더 패턴에 따라 객체를 생성할 수 있는 메소드를 자동으로 생성

public class OrderItem {
	private int oiNo;
	private int oiQty;
	
	/***********FK***********/
	private Order order;
	private Product product;
	
}
