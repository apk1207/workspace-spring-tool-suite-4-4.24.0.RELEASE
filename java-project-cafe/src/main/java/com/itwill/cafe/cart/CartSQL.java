package com.itwill.cafe.cart;

public class CartSQL {

	public static final String CART_INSERT = "insert into cart(cart_no, cart_qty, p_no, userid) values(cart_cart_no_seq.nextval, ?, ?, ?)";
	public static final String CART_DELETE_BY_USERID = "delete from cart where userid = ?";
	public static final String CART_DELETE_BY_CART_NO = "delete from cart where cart_no = ?";
	public static final String CART_UPDATE_BY_CART_NO = "update cart set cart_qty = ? where cart_no=?";
	public static final String CART_UPDATE_BY_PRODUCT_NO = "update cart set cart_qty=cart_qty+? where userid=? and p_no=?";
}
