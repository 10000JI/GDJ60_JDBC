package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.employees.EmployeeDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		DepartmentController departmentController = new DepartmentController();
		LocationController locationController = new LocationController();
		EmployeeController employeeController = new EmployeeController();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			//departmentController.start();
			locationController.start();
			//employeeController.start();
			//employeeDAO.getAvg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finish");
	}

}
