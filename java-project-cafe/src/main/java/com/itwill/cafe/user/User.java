package com.itwill.cafe.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(100) 
PASSWORD          VARCHAR2(100) 
NAME              VARCHAR2(100) 
PHONE             VARCHAR2(100) 
EMAIL             VARCHAR2(200)
 */
/*
@Getter					// 클래스 접근자 메서드(getter) 자동으로 생성
@Setter					// 클래스 수정자 메서드(setter) 자동으로 생성
*/
@Data					// getter, setter, toString, equals 등의 어노테이션들이 포함되어 함꼐 생성
@AllArgsConstructor		// 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@NoArgsConstructor		// 매개변수가 없는 기본 생성자를 자동으로 생성
@Builder				// 빌더 패턴에 따라 객체를 생성할 수 있는 메소드를 자동으로 생성

public class User {
	private String userId;
	private String password;
	private String name;
	private String phone;
	private String email;
	
	
	
}
