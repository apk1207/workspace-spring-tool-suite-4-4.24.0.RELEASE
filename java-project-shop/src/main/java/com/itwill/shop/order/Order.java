package com.itwill.shop.order;
/*
이름      널?       유형            
------- -------- ------------- 
O_NO    NOT NULL NUMBER(10)    
O_DESC           VARCHAR2(100) 
O_DATE           DATE          
O_PRICE          NUMBER(10)    
USERID           VARCHAR2(50)(FK) 
 */

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.itwill.shop.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private int o_no;
	private String o_desc;
	private Date o_date;
	private int o_price;
	/********FK*********/
	private User user;
	
	@Default
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();
	
}