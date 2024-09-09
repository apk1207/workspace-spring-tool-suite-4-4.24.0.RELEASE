<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@page import="com.itwill.shop.user.UserService"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@page import="com.itwill.shop.cart.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("jumun_list.jsp");
		return;
	}
	String buyType=request.getParameter("buyType");
	String p_noStr=request.getParameter("p_no");
	String p_qtyStr=request.getParameter("p_qty");

	CartService cartService=new CartService();
	UserService userService=new UserService();
	ProductService productService=new ProductService();
		
	ArrayList<Cart> cartList=new ArrayList<Cart>();
	User user=userService.findUser(sUserId);
	
	if(buyType.equals("cart")){
	 	cartList = cartService.getCartList(sUserId);
	}else if(buyType.equals("direct")){
		Product product=productService.getProduct(Integer.parseInt(p_noStr));
		cartList.add(new Cart(0,user,product,Integer.parseInt(p_qtyStr)));
	}
	
%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
form > table tr td{
	border: 0.1px solid black;
}
</style>
<script type="text/javascript">
      function jumun_create_form_submit(){
    	  document.jumun_create_form.method='POST';
    	  document.jumun_create_form.action='jumun_create_action.jsp';
    	  document.jumun_create_form.submit();
      }
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											주문/결제폼</b></td>
								</tr>
							</table> <!--form-->
							<form name="jumun_create_form" method="post">
								<input type="hidden" name="buyType" value="<%=buyType%>">
								<input type="hidden" name="p_no" value="<%=p_noStr%>">
								<input type="hidden" name="p_qty" value="<%=p_qtyStr%>">
							    <table align=center width=80% cellspacing=0
									bordercolordark=#FFFFFF bordercolorlight=#4682b4>
									<caption style="text-align: left;">구매자정보</caption>
									<tr>
										<td width=290 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>아이디</font></td>
										<td width=112 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>이름</font></td>
										<td width=166 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>이메일</font></td>
										<td width=50 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>비 고</font></td>
									</tr>
									<tr>
										<td width=290 height=26 align=center class=t1><%=user.getUserId()%></td>
										<td width=112 height=26 align=center class=t1><%=user.getName()%></td>
										<td width=166 height=26 align=center class=t1><%=user.getEmail()%></td>
										<td width=50 height=26 align=center class=t1></td>
									</tr>
								</table>
									
								<br/>	
								
								<table align=center  width=80% cellspacing=0
									bordercolordark=#FFFFFF bordercolorlight=#4682b4 >
									<caption style="text-align: left;">주문제품목록</caption>
									<tr style="border: 0.1px solid">
										<td width=290 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>강아지 이름</font></td>
										<td width=112 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>수 량</font></td>
										<td width=166 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>가 격</font></td>
										<td width=50 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>비 고</font></td>
									</tr>
									<%
									int tot_price=0;	
									for(Cart cart:cartList){ 
										tot_price+=cart.getCart_qty()*cart.getProduct().getP_price();
									%>
									<!-- cart item start -->
									<tr>
										<td width=290 height=26 align=center class=t1>
											<a href='product_detail.jsp?p_no=<%=cart.getProduct().getP_no()%>'><%=cart.getProduct().getP_name()%></a>
										</td>
										<td width=112 height=26 align=center class=t1><%=cart.getCart_qty()%></td>
										<td width=166 height=26 align=center class=t1>
											<%=new DecimalFormat("#,###").format(cart.getCart_qty()*cart.getProduct().getP_price())%>
										</td>
										<td width=50 height=26 align=center class=t1></td>
									</tr>
									<!-- cart item end -->
									<%}%>
									<tr>
										<td width=640 colspan=4 height=26 class=t1>
											<p align=right>
												<font color=#FF0000>총 주문 금액 : 
												<%=new DecimalFormat("#,###").format(tot_price) %> 원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center> &nbsp;&nbsp;
									<a href="javascript:jumun_create_form_submit();"
										class=m1>구매/결재하기</a>
										&nbsp;&nbsp;<a href=product_list.jsp
										class=m1>계속 쇼핑하기</a>

									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>