package com.sunil.library.library.uiModel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity// You have to install the jar by commmand line in eclipse to see it executable.


public class Student extends BaseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Version
	private Integer version;

	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name="student_id")
	//Before writing @Joincolumn seperate table was created student_courses...after writing 
	//@Joincolumn no table was created it will add new column in course with "student_id" as foreign key..
	//1..e it will take primary jey from student and use as a foreign key in course;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//It has a created a student id in course table and also created a seperate table with course_students with 
	//courseid and student id
	@JoinTable(
			joinColumns= {@JoinColumn(name="studentid",referencedColumnName="id")
},
     inverseJoinColumns= {
    		 @JoinColumn(name="Courseid",referencedColumnName="id")
     }
			)
	private List<Course> courses;
	

}
