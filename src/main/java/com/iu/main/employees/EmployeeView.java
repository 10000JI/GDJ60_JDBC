package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	public void view(ArrayList<EmployeeDTO> ar) {
		for(EmployeeDTO dto: ar) {
			this.view(dto);			
		}
	}
	public void view(EmployeeDTO dto) {
		System.out.println("=========================");
		System.out.println("사원번호:"+dto.getEmployee_id());
		System.out.println("성:"+dto.getFirst_name());
		System.out.println("이름:"+dto.getLast_name());
		System.out.println("직급:"+dto.getJob_id());
		System.out.println("부서번호:"+dto.getDepartment_id());
	}
	public void view(String msg) {
		System.out.println(msg);
	}
}
