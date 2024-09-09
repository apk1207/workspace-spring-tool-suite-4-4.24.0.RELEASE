package com.itwill.shop.jumun.test;

import java.sql.Date;
import java.util.ArrayList;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.jumun.Jumun;
import com.itwill.shop.jumun.JumunDao;
import com.itwill.shop.jumun.JumunDetail;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;
import com.itwill.shop.user.User;

public class JumunDaoTestMain {

	public static void main(String[] args) throws Exception{
		JumunDao jumunDao=new JumunDao();
		System.out.println(jumunDao.list("guard1"));
		System.out.println(jumunDao.detail("guard1",1));
		
		/*
		 * 1.상품에서직접주문
		 */
		int p_qty=1;
		int p_no=1;
		ProductDao productDao=new ProductDao();
		Product product=productDao.getProduct(p_no);
		
		ArrayList<JumunDetail> jumunDetailList=new ArrayList<JumunDetail>();
		jumunDetailList.add(new JumunDetail(0, p_qty, p_no, product));
		Jumun newJumun=new Jumun(0,product.getP_name()+"외 0종" , new Date(0), product.getP_price(), "guard3",jumunDetailList);
		
		jumunDao.create(newJumun);
		System.out.println(jumunDao.list("guard3"));
		
		/*
		 * 2.cart에서 주문
		 */
		
		
	}

}
