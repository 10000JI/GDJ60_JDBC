package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	//Employees
	//1. 사원정보리스트 - 신입사원 순으로 출력(사원번호, 성, 이름, 직급, 부서번호)
	//2. 개별사원정보 - 사원 한명의 모든 정보 출력(사원번호 = 중복되지 않는 번호)
	//3. 사원검색(LastName) - 사원 이름으로 검색 (Like)
	//4. 종료
	//+)dto에서 고용일자는 java.sql.date
	
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private EmployeeInput employeeInput;

	public EmployeeController() {
		this.sc = new Scanner(System.in);
		this.employeeDAO = new EmployeeDAO();
		this.employeeView = new EmployeeView();
		this.employeeInput = new EmployeeInput();
	}
	
	public void start() throws Exception {
		boolean check = true;
		ArrayList<EmployeeDTO> ar = null;
		EmployeeDTO employeeDTO = null;
		while(check) {
			System.out.println("1.사원정보리스트");
			System.out.println("2.개별사원정보");
			System.out.println("3.사원   검색");
			System.out.println("4.사원   추가");
			System.out.println("5.사원   삭제");
			System.out.println("6.사원   수정");
			System.out.println("7.종    료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.print("사원번호를 입력하세요: ");
				select = sc.nextInt();
				employeeDTO = employeeDAO.getDetail(select);
				if(employeeDTO != null) {
					employeeView.view(employeeDTO);
				}else {
					employeeView.view("Data가 없다");
				}
				break;
			case 3:
				System.out.print("검색할 사원 이름 입력:");
				String add = sc.next();
				ar = employeeDAO.getFind(add);
				employeeView.view(ar);
				break;
			case 4:
				employeeDTO = employeeInput.setData();
				select = employeeDAO.setData(employeeDTO);
				if(select > 0) {
					employeeView.view("추가 성공");
				}else {
					employeeView.view("추가 실패");
				}
				break;
			case 5:
				employeeDTO = employeeInput.deleteData();
				select = employeeDAO.deleteData(employeeDTO);
				if(select > 0) {
					employeeView.view("사원 삭제 성공");
				}else {
					employeeView.view("사원 삭제 실패");
				}
				break;
			case 6:
				employeeDTO = employeeInput.updateData();
				select = employeeDAO.updateData(employeeDTO);
				if(select > 0) {
					employeeView.view("사원 수정 성공");
				}else {
					employeeView.view("사원 수정 실패");
				}
				break;
			default:
				check = false;
			}
		}
	}
	
	
}
