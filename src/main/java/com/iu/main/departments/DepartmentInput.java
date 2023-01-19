package com.iu.main.departments;

import java.util.Scanner;

public class DepartmentInput {
	private Scanner sc;
	
	public DepartmentInput() {
		this.sc = new Scanner(System.in);
	}
	
	//추가
	public DepartmentDTO setDate() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.print("부서명 입력: ");
		departmentDTO.setDepartment_name(sc.next());
		System.out.print("매니저 번호 입력: ");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.print("지역 번호 입력: ");
		departmentDTO.setLocation_id(sc.nextInt());
		return departmentDTO;
	}

	//삭제
	public DepartmentDTO deleteDate() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.print("부서 번호 입력: ");
		departmentDTO.setDepartment_id(sc.nextInt());
		return departmentDTO;
	}
	
	//수정
	public DepartmentDTO updateDate() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.print("수정할 부서 번호 입력: ");
		departmentDTO.setDepartment_id(sc.nextInt());
		System.out.print("수정할 부서 명 입력: ");
		departmentDTO.setDepartment_name(sc.next());
		System.out.print("수정할 매니저 번호 입력: ");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.print("수정할 지역 번호 입력: ");
		departmentDTO.setLocation_id(sc.nextInt());
		return departmentDTO;
	}
}
