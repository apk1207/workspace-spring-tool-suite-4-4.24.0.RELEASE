/************************users insert******************/
--desc users;

-- 회원정보 추가
insert into users(userid,password,name,phone,email) values('user1','qqq','김철수','111-1111','qqq@qqq');
insert into users(userid,password,name,phone,email) values('user2','www','김철수','222-2222','www@www');
insert into users(userid,password,name,phone,email) values('user3','eee','김철수','333-3333','eee@eee');


/************************product insert******************/
--desc product;

-- 메뉴정보 추가
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'Americano.png','아메리카노','고품질 원두로 내린 에스프레소를 사용한 대표 메뉴',3500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'CaffeLatte.png','카페라떼','쓴맛이 덜하면서도 고소한 맛까지 느낄수 있는 커피',4500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'CaramelMacchiato.png','카라멜마끼아또','달달한 커피가 떙길 떄 추천!.',4500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'IcedTea.png','복숭아아이스티','달콤하고 시원한게 떙길떄 추천.',2500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'Lemonade.png','레모네이드','레몬의 상큼한 향이 일품.',2500);


/************************cart insert******************/
--desc cart;

-- 상품 장바구니 추가
insert into cart(cart_no, cart_qty, p_no, userid) values(cart_cart_no_seq.nextval, 2, 1, 'user1');
insert into cart(cart_no, cart_qty, p_no, userid) values(cart_cart_no_seq.nextval, 1, 2, 'user1');
insert into cart(cart_no, cart_qty, p_no, userid) values(cart_cart_no_seq.nextval, 4, 5, 'user1');


/************************orders / order_item insert******************/
--desc orders;
--desc order_item;


insert into orders(o_no, o_desc, o_date, o_price, userid) values(orders_o_no_seq.nextval,'아메리카노외2종',sysdate, 12500, 'user1');
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,1,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,1,orders_o_no_SEQ.currval,3);

insert into orders(o_no, o_desc, o_date, o_price, userid) values(orders_o_no_seq.nextval,'카페라떼외2종',sysdate, 14500, 'user2');
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,1,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,2,orders_o_no_SEQ.currval,4);
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,2,orders_o_no_SEQ.currval,5);

insert into orders(o_no, o_desc, o_date, o_price, userid) values(orders_o_no_seq.nextval,'복숭아이스티외1종',sysdate, 10000, 'user3');
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,2,orders_o_no_SEQ.currval,4);
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_seq.nextval,2,orders_o_no_SEQ.currval,5);

