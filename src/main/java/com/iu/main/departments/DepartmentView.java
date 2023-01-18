package com.iu.main.departments;

import java.util.ArrayList;

public class DepartmentView {
	public void view(ArrayList<DepartmentDTO> ar) {
		for(DepartmentDTO dto:ar) {
			this.view(dto);
		}
	}
	public void view(DepartmentDTO dto) {
		System.out.println("===============================");
		System.out.println("부서번호: "+dto.getDepartment_id());
		System.out.println("부서이름: "+dto.getDepartment_name());
		System.out.println("관리자번호: "+dto.getManager_id());
		System.out.println("지역번호: "+dto.getLocation_id());
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
}
