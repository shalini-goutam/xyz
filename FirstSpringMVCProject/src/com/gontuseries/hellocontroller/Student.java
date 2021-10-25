package com.gontuseries.hellocontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	@Pattern(regexp="[^0-9]*")
	private String studentName;//variable name should be same as attribute value in admission form page for binding
	
	/*spring MVC says if the value which you are binding with hobby field is <2 or >5 then treat that as data binding related error and put that in bindingResult reference.
	message is used to provide customized error message otherwise spring mvc uses default error message.*/
	//@Size(min=2,max=30, message="Please enter a value for student hobby field between 2 and 30 characters")
	//@Size(min=2,max=30, message="Please enter a value for student hobby field between {min} and {max} characters")//{min} and {max} is used to provide  min and max values dynamically into the error message
	@Size(min=2,max=30)@IsValidHobby
	private String studentHobby;
	
	@Max(2222)
	private Long studentMobile;
	
	@Past
	private Date studentDOB;
	private Address studentAddress;
	private ArrayList<String> studentSkills;
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	
	
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	
	

}
