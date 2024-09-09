package com.itwill.shop.jumun;

import java.util.ArrayList;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class JumunService {
	private JumunDao jumunDao;
	private ProductDao productDao;
	private CartDao cartDao;
	public JumunService() throws Exception{
		jumunDao=new JumunDao();
		productDao=new ProductDao();
		cartDao=new CartDao();
	}
	/*
	 * 주문삭제
	 */
	public int delete(int j_no)throws Exception{
		return jumunDao.delete(j_no);
	}
	
	
	/*
	 * 주문목록
	 */
	public ArrayList<Jumun> list(String sUserId) throws Exception{
		return jumunDao.list(sUserId);
	}
	/*
	 * 주문상세보기
	 */
	public Jumun detail(String sUserId,int j_no)throws Exception{
		return jumunDao.detail(sUserId,j_no);
	}
	/*
	 * 상품에서 직접주문
	 */
	public int create(String sUserId,int p_no,int jd_qty) throws Exception{
		Product product=productDao.getProduct(p_no);
		JumunDetail jumunDetail=new JumunDetail(0, jd_qty, p_no, product);
		ArrayList<JumunDetail> jumunDetailList=new ArrayList<JumunDetail>();
		jumunDetailList.add(jumunDetail);
		
		Jumun newJumun=
				new Jumun(0,
						jumunDetailList.get(0).getProduct().getP_name()+"외 0종", 
						null,
						jumunDetailList.get(0).getJd_qty()*jumunDetailList.get(0).getProduct().getP_price(),
						sUserId,
						jumunDetailList);
		return jumunDao.create(newJumun);
	}
	
	/*
	 * cart에서 주문
	 */
	public int create(String sUserId) throws Exception{
		ArrayList<Cart> cartList=cartDao.getCartList(sUserId);
		ArrayList<JumunDetail> jumunDetailList=new ArrayList<JumunDetail>();
		int j_tot_price=0;
		for (Cart cart : cartList) {
			JumunDetail jumunDetail=new JumunDetail(0,cart.getCart_qty(),0, cart.getProduct());
			jumunDetailList.add(jumunDetail);
			j_tot_price+=jumunDetail.getJd_qty()*jumunDetail.getProduct().getP_price();
		}
		String j_desc = jumunDetailList.get(0).getProduct().getP_name()+"외 "+jumunDetailList.size()+" 종";
		Jumun newJumun=new Jumun(0,j_desc, null, j_tot_price, sUserId,jumunDetailList);
		jumunDao.create(newJumun);
		cartDao.deleteCart(sUserId);
		return 0;
	}
	
}













