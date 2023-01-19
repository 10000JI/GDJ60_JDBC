package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	private Scanner sc;
	
	public EmployeeInput() {
		this.sc = new Scanner(System.in);
	}
	
	public EmployeeDTO deleteData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		System.out.print("삭제할 사원 번호 입력: ");
		employeeDTO.setEmployee_id(sc.nextInt());
		return employeeDTO;
	}
	
	public EmployeeDTO setData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		System.out.print("추가할 사원의 성 입력: ");
		employeeDTO.setFirst_name(sc.next());
		System.out.print("추가할 사원의 이름 입력: ");
		employeeDTO.setLast_name(sc.next());
		System.out.print("추가할 사원의 이메일 입력: ");
		employeeDTO.setEamil(sc.next());
		System.out.println("추가할 사원의 핸드폰번호 입력:");
		employeeDTO.setPhone_number(sc.next());
		System.out.println("추가할 사원의 직무를 입력:");
		employeeDTO.setJob_id(sc.next());
		System.out.println("추가할 사원의 월급를 입력:");
		employeeDTO.setSalary(sc.nextDouble());
		System.out.println("추가할 사원의 수당율을 입력:");
		employeeDTO.setCommision_pct(sc.nextDouble());
		System.out.println("추가할 사원의 상사번호를 입력:");
		employeeDTO.setManager_id(sc.nextInt());
		System.out.println("추가할 사원의 부서번호를 입력:");
		employeeDTO.setDepartment_id(sc.nextInt());
		return employeeDTO;	
	}
	
	public EmployeeDTO updateData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		System.out.print("수정할 사원 번호 입력: ");
		employeeDTO.setEmployee_id(sc.nextInt());
		System.out.print("수정할 사원의 성 입력: ");
		employeeDTO.setFirst_name(sc.next());
		System.out.print("수정할 사원의 이름 입력: ");
		employeeDTO.setLast_name(sc.next());
		System.out.print("수정할 사원의 이메일 입력: ");
		employeeDTO.setEamil(sc.next());
		return employeeDTO;
	}
	
	
}
