package com.revature.beans;

import java.util.Date;

public class FormBean {
	
	//NEED TO MATCH HTML FORM NAMES
	
	
	private int form_id;
	private String emp_name;
	private String emp_last_name;
	private String location;
	private float cost_ammount;
	private Date dStart = new Date();
	private Date dEnd = new Date();
	private String type_course;
	private int grade;
	private String status;
	public FormBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormBean(int form_id, String emp_name, String emp_last_name, String location, float cost_ammount,
			Date dStart, Date dEnd, String type_course, int grade, String status) {
		super();
		this.form_id = form_id;
		this.emp_name = emp_name;
		this.emp_last_name = emp_last_name;
		this.location = location;
		this.cost_ammount = cost_ammount;
		this.dStart = dStart;
		this.dEnd = dEnd;
		this.type_course = type_course;
		this.grade = grade;
		this.status = status;
	}
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_last_name() {
		return emp_last_name;
	}
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getCost_ammount() {
		return cost_ammount;
	}
	public void setCost_ammount(float cost_ammount) {
		this.cost_ammount = cost_ammount;
	}
	public Date getdStart() {
		return dStart;
	}
	public void setdStart(Date dStart) {
		this.dStart = dStart;
	}
	public Date getdEnd() {
		return dEnd;
	}
	public void setdEnd(Date dEnd) {
		this.dEnd = dEnd;
	}
	public String getType_course() {
		return type_course;
	}
	public void setType_course(String type_course) {
		this.type_course = type_course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FormBean [form_id=" + form_id + ", emp_name=" + emp_name + ", emp_last_name=" + emp_last_name
				+ ", location=" + location + ", cost_ammount=" + cost_ammount + ", dStart=" + dStart + ", dEnd=" + dEnd
				+ ", type_course=" + type_course + ", grade=" + grade + ", status=" + status + "]";
	}
	
	
}
