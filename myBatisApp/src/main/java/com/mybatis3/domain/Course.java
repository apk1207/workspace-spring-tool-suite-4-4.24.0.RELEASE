package com.mybatis3.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
<< COURSES >>
이름          널?       유형            
----------- -------- ------------- 
COURSE_ID   NOT NULL NUMBER(11)    
NAME        NOT NULL VARCHAR2(100) 
DESCRIPTION          VARCHAR2(512) 
START_DATE           DATE          
END_DATE             DATE          
TUTOR_ID    NOT NULL NUMBER(11)  (FK)  	

 << COURSE_ENROLLEMENT >>
이름        널?       유형         
--------- -------- ---------- 
COURSE_ID NOT NULL NUMBER(11) 
STUD_ID   NOT NULL NUMBER(11)  


 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private Integer courseId;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	//FK
	private Tutor tutor;
	
	private List<Student> students;
	
}