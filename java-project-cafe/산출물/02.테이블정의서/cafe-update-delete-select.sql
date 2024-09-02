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
desc cart;

-- user1 의 장바구니 내역 삭제
delete from cart where userid = 'user1';

