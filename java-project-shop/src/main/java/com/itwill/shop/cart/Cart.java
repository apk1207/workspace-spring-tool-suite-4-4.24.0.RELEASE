package com.itwill.shop.cart;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름       널?       유형            
-------- -------- ------------- 
CART_NO  NOT NULL NUMBER(10)    
CART_QTY          NUMBER(10)    
P_NO              NUMBER(10)    
USERID            VARCHAR2(100)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	
	private int cart_no;
	private int cart_qty;
	/********FK*********/
	//private String userid;
	private User user;
	/********FK*********/
	//private int p_no;
	private Product product;
}
