package com.itwill.shop.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
VO(Value Object),DTO(Data Transfer Object)
	- product 테이블 1개 row의 데이타의 값을 가지는객체
	- product 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- product 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름            널?       유형            
------------- -------- ------------- 
P_NO          NOT NULL NUMBER(10)    
P_NAME                 VARCHAR2(50)  
P_PRICE                NUMBER(10)    
P_IMAGE                VARCHAR2(100) 
P_DESC                 VARCHAR2(100) 
P_CLICK_COUNT          NUMBER(10)      
 */

/* lombok라이브러리를 사용하여 메소드모음 호출 */

@Data
@Builder
// 모든인자를 사용한 생성자 생성
@AllArgsConstructor
// 기본생성자 생성
@NoArgsConstructor
public class Product {
	
	private int p_no;
	private String p_name;
	private int p_price;
	private String p_image;
	private String p_desc;
	private int p_click_count;
}
