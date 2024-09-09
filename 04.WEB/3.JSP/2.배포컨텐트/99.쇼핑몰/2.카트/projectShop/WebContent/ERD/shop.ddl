DROP TABLE jumun_detail CASCADE CONSTRAINTS;
DROP TABLE jumun CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;

CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL 		 PRIMARY KEY,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_image                       		VARCHAR2(100)		 DEFAULT 'images/no_image.jpg'		 NOT NULL,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_click_count                 		VARCHAR2(10)		 DEFAULT 0		 NOT NULL
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE userinfo(
		userId                        		VARCHAR2(100)		 NULL 		 PRIMARY KEY,
		password                      		VARCHAR2(100)		 NULL ,
		name                          		VARCHAR2(100)		 NULL ,
		email                         		VARCHAR2(100)		 NULL 
);


CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL 		 PRIMARY KEY,
		userId                        		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 DEFAULT 0		 NULL ,
  FOREIGN KEY (userId) REFERENCES userinfo (userId),
  FOREIGN KEY (p_no) REFERENCES product (p_no)
);

DROP SEQUENCE cart_cart_no_SEQ;

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE jumun(
		j_no                          		NUMBER(10)		 NULL 		 PRIMARY KEY,
		j_desc                        		VARCHAR2(100)		 NULL ,
		j_date                        		DATE		 DEFAULT sysdate		 NULL ,
		j_price                       		NUMBER(10)		 NULL ,
		userId                        		VARCHAR2(100)		 NULL ,
  FOREIGN KEY (userId) REFERENCES userinfo (userId)
);

DROP SEQUENCE jumun_j_no_SEQ;

CREATE SEQUENCE jumun_j_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE jumun_detail(
		jd_no                         		NUMBER(10)		 NULL 		 PRIMARY KEY,
		jd_qty                        		NUMBER(10)		 NULL ,
		j_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
  FOREIGN KEY (j_no) REFERENCES jumun (j_no),
  FOREIGN KEY (p_no) REFERENCES product (p_no)
);

DROP SEQUENCE jumun_detail_jd_no_SEQ;

CREATE SEQUENCE jumun_detail_jd_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




