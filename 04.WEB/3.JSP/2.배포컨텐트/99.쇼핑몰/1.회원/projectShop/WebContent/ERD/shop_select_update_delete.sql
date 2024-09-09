--guard1 멤버한사람의  카트에 제품존재여부

--guard1 멤버한사람의 카트아이템리스트
select * 
from cart c join userinfo u
on c.userid=u.userid 
join product p 
on p.p_no=c.p_no
where u.userid='guard1';


--guard1 멤버한사람의  카트아이템 1개의 제품정보

--guard1 카트에 있는 제품 수량증가

--guard1님 카트아이템1개삭제

--guard1님 카트아이템모두삭제
