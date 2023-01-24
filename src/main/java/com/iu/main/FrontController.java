package com.iu.main;

import java.util.Scanner;

import com.iu.main.countries.CountryController;
import com.iu.main.departments.DepartmentController;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationController;
import com.iu.main.regions.RegionController;

public class FrontController {
	private Scanner sc;
	private DepartmentController departmentController;
	private LocationController locationController;
	private EmployeeController employeeController;
	private CountryController countryController;
	private RegionController regionController;
	
	public FrontController() {
		this.sc = new Scanner(System.in);
		this.departmentController = new DepartmentController();
		this.locationController = new LocationController();
		this.employeeController = new EmployeeController();
		this.countryController = new CountryController();
		this.regionController = new RegionController();
	}
	
	public void start() throws Exception {
		boolean check= true;
		while(check) {
			System.out.println("1.부서 관리");
			System.out.println("2.지역 관리");
			System.out.println("3.사원 관리");
			System.out.println("4.나라 관리");
			System.out.println("5.대륙 관리");
			System.out.println("6.종   료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				this.departmentController.start();
				break;
			case 2:
				this.locationController.start();
				break;
			case 3:
				this.employeeController.start();
				break;
			case 4:
				this.countryController.start();
				break;
			case 5:
				this.regionController.start();
				break;
			default:
				check = false;
			}
		}
	}	
}
