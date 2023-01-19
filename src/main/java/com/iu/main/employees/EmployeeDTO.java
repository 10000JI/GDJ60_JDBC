package com.iu.main.employees;

import java.sql.Date;

public class EmployeeDTO {
	//int와 같은 primitive보단 Integer인 reference로
	//자바는 보통 카멜케이스 표기법 으로 쓰지만
	//db의 컬럼명과 동일하게 하기 위해 스네이크 표기법 사용
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String eamil;
	private String phone_number;
	//자바 Date 
	//1)java.util 2)java.sql
	//1)은 deprecated되어 있으므로 2)로 사용
	//2)는 1)을 상속받음
	private Date hire_date;
	private String job_id;
	private double salary;
	private double commision_pct;
	private Integer manager_id;
	private Integer department_id;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommision_pct() {
		return commision_pct;
	}
	public void setCommision_pct(double commision_pct) {
		this.commision_pct = commision_pct;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	
}
