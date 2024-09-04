package com.itwill.cafe.order;
/*
이름      널?       유형            
------- -------- ------------- 
O_NO    NOT NULL NUMBER(10)    
O_DESC           VARCHAR2(100) 
O_DATE           DATE          
O_PRICE          NUMBER(10)    
USERID           VARCHAR2(100) 
 */

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.itwill.cafe.product.Product;
import com.itwill.cafe.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// getter, setter, toString, equals 등의 어노테이션들이 포함되어 함꼐 생성
@AllArgsConstructor		// 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@NoArgsConstructor		// 매개변수가 없는 기본 생성자를 자동으로 생성
@Builder				// 빌더 패턴에 따라 객체를 생성할 수 있는 메소드를 자동으로 생성

public class Order {
	
	private int oNo;
	private String oDesc;
	private Date oDate;
	private int oPrice;
	/********FK********/
	private User user;
	
	/********FK********/
	@Default
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
}
