/************************users insert******************/
--desc users;

insert into users(userid,password,name,phone,email) values('user1','qqq','김철수','111-1111','qqq@qqq');
insert into users(userid,password,name,phone,email) values('user2','www','김철수','222-2222','www@www');
insert into users(userid,password,name,phone,email) values('user3','eee','김철수','333-3333','eee@eee');


/************************product insert******************/
--desc product;

insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'Americano.png','아메리카노','고품질 원두로 내린 에스프레소를 사용한 대표 메뉴',3500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'CaffeLatte.png','카페 라떼','쓴맛이 덜하면서도 고소한 맛까지 느낄수 있는 커피',4500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'CaramelMacchiato.png','카라멜 마끼아또','달달한 커피가 떙길 떄 추천!.',4500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'IcedTea.png','복숭아 아이스티','달콤하고 시원한게 떙길떄 추천.',2500);
insert into product(p_no,p_image,p_name,p_desc,p_price) values(PRODUCT_P_NO_SEQ.nextval,'Lemonade.png','레모네이드','레몬의 상큼한 향이 일품.',2500);


/************************cart insert******************/
--desc cart;

insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_seq.nextval,'user1',1,2);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_seq.nextval,'user1',4,1);
insert into cart(cart_no,userid,p_no,cart_qty) values(cart_cart_no_seq.nextval,'user1',5,3);


--SELECT * FROM users WHERE userid = 'user1';