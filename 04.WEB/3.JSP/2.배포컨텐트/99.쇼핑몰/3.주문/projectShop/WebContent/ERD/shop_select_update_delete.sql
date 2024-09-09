--guard1 멤버한사람의  카트에 제품번호 존재여부
select count(*)  as p_count from cart c join userinfo u on c.userid=u.userid where u.userid='guard1' and c.p_no=1;

--guard1 멤버한사람의 카트아이템리스트
select * 
from cart c join userinfo u
on c.userid=u.userid 
join product p 
on p.p_no=c.p_no
where u.userid='guard1';

--카트아이템 1개의 제품정보(guard1 멤버한사람)
select * from cart c join product p on c.p_no=p.p_no where cart_no=1 ;

--guard1 카트에 있는 1번제품의 수량증가
update cart set cart_qty=cart_qty+1 where userid='guard1' and p_no=1;

--guard1님 카트아이템1개삭제
delete from cart where cart_no=1;
--guard1님 카트아이템모두삭제
delete from cart where userid='guard1';


--1. 멤버 한사람의 주문전체목록
select * from jumun where userid='guard1';

--2. 주문한개(멤버 한사람의) 
select * from jumun where j_no=1;


--3. 주문한개의  주문상세 여러개(주문상세)
select * from jumun_detail where j_no = 1;

--4. 주문한개의 주문상세,제품정보 여러개(주문상세,제품)
select * from jumun j join jumun_detail jd on j.j_no=jd.j_no  join  product p on jd.p_no=p.p_no where j.userid='guard1' and j.j_no = 1;

--5. 주문한개삭제(주문1개삭제,주문상세삭제)
--on delete cascade
delete from jumun_detail where j_no=1;
delete from jumun where j_no=1;
--rollback;
--6. 멤버한사람의 주문내역전체삭제
----on delete cascade
--select j_no from jumun where userid='guard1';
delete from jumun_detail where j_no in(select j_no from jumun where userid='guard1');
delete from jumun where userid='guard1';














