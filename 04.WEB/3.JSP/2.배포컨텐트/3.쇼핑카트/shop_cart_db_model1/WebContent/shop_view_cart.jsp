<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.cart.CartItemDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>
<%
	CartService cartService=new CartService();
	ArrayList<CartItemDto> cartItemList=cartService.getCartItemList(sUserId);
%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function view_cart_form_submit(){
		document.view_cart_form.method='POST';
		document.view_cart_form.action='shop_jumun_create_form.jsp';
		document.view_cart_form.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form name="view_cart_form">
		<input type="hidden" name="buyType" value="cart">
	</form>
	
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
											장바구니 보기</b></td>
								</tr>
							</table> 
							<!--form-->
							<!-- 
							<form name="f" method="post">
							 -->
							<div id='f'>
							<table  align=center border=1 width=80% cellspacing=0
									bordercolordark=#FFFFFF bordercolorlight=#4682b4>
									<tr>
										<td width=40 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>이미지</font></td>
										<td width=250 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>강아지 이름</font></td>
										<td width=112 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>수 량</font></td>
										<td width=166 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>가 격</font></td>
										<td width=50 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>비 고</font></td>
									</tr>
									<%
									int totPrice=0;
									DecimalFormat df=new DecimalFormat("#,##0");
									for(CartItemDto cartItem:cartItemList){
										totPrice+=cartItem.getCart_tot_price();
									%>
									<!-- cart item start -->
									<tr>
										<td width=40 height=26 align=center class=t1><img src='image/<%=cartItem.getP_image()%>' width="40" height="28"/></td>
										<td width=250 height=26 align=center class=t1><a href='shop_product_detail.jsp?p_no=<%=cartItem.getP_no()%>'><%=cartItem.getP_name()%></a></td>
										<td width=112 height=26 align=center class=t1><%=cartItem.getCart_qty()%></td>
										<td width=166 height=26 align=center class=t1><%=df.format(cartItem.getCart_tot_price())%></td>
										<td width=50 height=26 align=center class=t1>
											<form action="shop_delete_item_cart.jsp" method="post">
												<input type="hidden" name="cart_itemno" value="<%=cartItem.getCart_item_no()%>">
												<input type="submit" value="삭제">
											</form>
										</td>
									</tr>
									<!-- cart item end -->
									<%}%>
									<tr>
										<td width=640 colspan=5 height=26 class=t1>
											<p align=right>
												<font color=#FF0000>총 금액 : <%=df.format(totPrice) %> 원
												</font>
											</p>
										</td>
									</tr>
								</table>
							
							</div>
							<!-- 
							</form> 
							 -->
							 
							<br />
							
							<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp;<a href=shop_delete_cart.jsp
										class=m1>장바구니 비우기</a>&nbsp;&nbsp;<a href=shop_product_list.jsp
										class=m1>계속 구경하기</a> 
										&nbsp;&nbsp;<a href="javascript:view_cart_form_submit();"
										class=m1>주문하기</a>

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