package com.iu.main.departments;

import java.util.ArrayList;

import com.iu.main.employees.EmployeeDTO;

public class DepartmentDTO {
	
	//1.모든 멤버변수의 접근지정자는 private
	//	int타입은 Integer로 reference로 선언
	//2.멤버변수의 데이터 타입과 변수명은
	//	Table의 컬럼의 데이터타입과 컬렴명과 일치
	//	컬럼명은 대소문자 구별X
	//3.Getter&Setter 생성
	//4.생성자는 여러개 있어도 상관X 
	//	꼭 기본생성자는 있어야 함
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	//부서는 사원의 정보를 가지고 있다 (포함관계 is a)
	//부서 하나에 사원 0명 이상 -> 1:N = ArrayList
	private ArrayList<EmployeeDTO> employeeDTOs;
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	public ArrayList<EmployeeDTO> getEmployeeDTOs() {
		return employeeDTOs;
	}
	public void setEmployeeDTOs(ArrayList<EmployeeDTO> employeeDTOs) {
		this.employeeDTOs = employeeDTOs;
	}

}
