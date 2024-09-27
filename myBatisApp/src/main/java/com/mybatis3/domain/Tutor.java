package com.mybatis3.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름       널?       유형           
-------- -------- ------------ 
TUTOR_ID NOT NULL NUMBER(11)   
NAME     NOT NULL VARCHAR2(50) 
EMAIL    NOT NULL VARCHAR2(50) 
PHONE             VARCHAR2(15) 
DOB               DATE         
ADDR_ID           NUMBER(11)  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tutor {
	private Integer tutorId;
	private String name;
	private String email;
	private Address address;
	
	private List<Course> courses;

}