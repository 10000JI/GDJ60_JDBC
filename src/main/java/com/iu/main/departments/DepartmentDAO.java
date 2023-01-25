package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.employees.EmployeeDTO;
import com.iu.main.util.DBConnection;

public class DepartmentDAO {
	
	public DepartmentDTO getInfors() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setEmployeeDTOs(new ArrayList<EmployeeDTO>());
		Connection connection = DBConnection.getConnection();
		//30번 부서에 근무하는 사원들의 이름과 부서명
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME"
				+ " FROM EMPLOYEES E"
				+ " INNER JOIN"
				+ " DEPARTMENTS D"
				+ " ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID)"
				+ " WHERE D.DEPARTMENT_ID = 30";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		//30번 부서에 근무하는 사람 여러명이므로 여러 개 리턴
		//부서는 한개, 사원들의 정보는 arraylist
		while(rs.next()) {
			if(departmentDTO.getDepartment_name() == null) {
				//반복해서 이름을 넣어주기 때문에 한번만 넣어주고 싶다면 null값일 때만 넣자
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
		}
		DBConnection.disConnect(st, connection);
		return departmentDTO;
	}
	
	//JOIN
	public DepartmentDTO getInfo() throws Exception{
		DepartmentDTO departmentDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME"
				+ " FROM EMPLOYEES E"
				+ " INNER JOIN"
				+ " DEPARTMENTS D"
				+ " ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID)"
				+ " WHERE E.EMPLOYEE_ID = 100";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		//한개의 값만 리턴
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setEmployeeDTOs(new ArrayList<EmployeeDTO>());
			//테이블별칭.컬럼명으로 getString (X), 표의 출력 결과는 컬럼명으로 나오기 때문에
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			//departmentDTO.getEmployeeDTOs().get(0).setFirst_name(rs.getString("FIRST_NAME"));
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
		}
		DBConnection.disConnect(rs, st, connection);
		return departmentDTO;
	}
	
	
	//update
	public int updateData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?,LOCATION_ID=?"
				+ " WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1,departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	//delete
	public int deleteData(DepartmentDTO departmentDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1,departmentDTO.getDepartment_id());
		int result = st.executeUpdate();
		return result;
	}
	
	
	//insert
	public int setData(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " VALUES(DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	public DepartmentDTO getDetail(int department_id) throws Exception{
		DepartmentDTO departmentDTO = null;
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, department_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}
		DBConnection.disConnect(rs, st, connection);
		return departmentDTO;
	}
	
	public ArrayList<DepartmentDTO> getList() throws Exception{
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		
		//DBConnection dbConnection = new DBConnection();
		//Connection connection = dbConnection.getConnection();
		Connection connection = DBConnection.getConnection();
		
		//3. 0uery문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//4. 0uery문 미리 전송
		//SQL injection을 방어하기 위해 PreparedStatement 탄생
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
}
