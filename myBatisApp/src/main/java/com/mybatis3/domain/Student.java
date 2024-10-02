package com.mybatis3.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/*
 << STUDENTS >>
이름      널?       유형           
------- -------- ------------ 
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
ADDR_ID          NUMBER(11)  (FK) 

 << COURSE_ENROLLEMENT >>
이름        널?       유형         
--------- -------- ---------- 
COURSE_ID NOT NULL NUMBER(11) 
STUD_ID   NOT NULL NUMBER(11) 
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Student {
	@NonNull
	@Default
	private Integer studId=0;
	@NonNull
	@Default
	private String name="";
	@NonNull
	@Default
	private String email="";
	@NonNull
	@Default
	private Date dob=new Date();
	@NonNull
	@Default
	private String phone="";
	
	private List<Course> courses;
	
	private Address address;
	
	
}