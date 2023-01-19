package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeeDAO {
	
	//method 1: query 1
	//list
	public ArrayList<EmployeeDTO> getList() throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		//1. DB연결
		Connection connection = DBConnection.getConnection();
		
		//2. Query문 생성
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ,LAST_NAME ,JOB_ID ,"
				+ "DEPARTMENT_ID FROM EMPLOYEES";
		
		//3. 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		//4. ?
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			//sql의 SELECT의 결과물을 가져옴
			//sql 컬럼명과 동일한 것만 get
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));  
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
		}
		
		//6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	//employee_id detail
	public EmployeeDTO getDetail(int employee_id) throws Exception {
		EmployeeDTO employeeDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ,LAST_NAME ,JOB_ID ,"
				+ "DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, employee_id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));  
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		DBConnection.disConnect(rs, st, connection);
		return employeeDTO;
	}
	
	//last_name find
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		//1. DB 연결
		Connection connection = DBConnection.getConnection();
		
		//2. Query문 생성
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ,LAST_NAME ,JOB_ID ,"
				+"DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		
		//3. 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//4. ? 
		//'%a%'는 %가 꼭 들어가야 됨
		st.setString(1, "%"+search+"%");
		
		//5. 최종 전송 및 결과 처리
		//ResultSet에서 String은 자동으로 '' 넣어줌
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));  
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
		}
		
		//6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
}
