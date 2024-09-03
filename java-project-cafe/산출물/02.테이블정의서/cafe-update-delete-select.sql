/***************users**********************/

--회원정보 수정
update users set password = '000', name = '김변경', phone = '000-0000', email = '000@000' where userid = 'user1';

--회원 user3 회원정보 삭제
delete from users where userid = 'user3';

--회원 user3 회원정보 조회
select * from users where userid = 'user3';


/***************product***********************/
--desc product;

--상품번호로 상품정보 조회
select * from product where p_no = 1;

--상품정보 전체 조회
select * from product;


/***************cart***********************/
--desc cart;

-- user1 의 장바구니 내역 삭제
delete from cart where userid = 'user1';

-- 장바구니에서 상품 수량 변경
update cart set cart_qty = 3 where cart_no=1;

-- 상품 정보에서 장바구니 수량 변경
update cart set cart_qty=cart_qty+2 where userid='user1' and p_no=1;

--user1 멤버한사람의 카트에 제품번호 존재여부
--장바구니에 제품을 추가할지, 업데이트 할지를 결정하기 위해 사용
select count(*) as p_count from cart where userid='user1' and p_no=2;
