package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	//월급의 평균
	public HashMap<String, Double> getAvg() throws Exception{
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT AVG(SALARY) AS A, SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		//1. List, Array,
		//2. DTO (Class): 자주 쓰이면 사용, 1회용이면 비추천 
		//3. Map (key 키,value 값): 1회용으로 추천 
		
		map.put("avg",rs.getDouble("A"));
		map.put("sum",rs.getDouble(2));
		
		System.out.println(rs.getDouble("A"));
		System.out.println(rs.getDouble(2));
		
		DBConnection.disConnect(rs, st, connection); 
		
		return map;
	}
	public int deleteData(EmployeeDTO employeeDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, employeeDTO.getEmployee_id());
		int result = st.executeUpdate();
		return result;
	}
	
	public int setData(EmployeeDTO employeeDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,"
				+ "HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEamil());
		st.setString(4, employeeDTO.getPhone_number());
		st.setString(5, employeeDTO.getHire_date());
		st.setString(6, employeeDTO.getJob_id());
		st.setDouble(7, employeeDTO.getSalary());
		st.setDouble(8, employeeDTO.getCommision_pct());
		st.setInt(9, employeeDTO.getManager_id());
		st.setInt(10, employeeDTO.getDepartment_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public int updateData(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE EMPLOYEES SET FIRST_NAME=?,LAST_NAME=?,EMAIL=?"
				+ " WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEamil());
		st.setInt(4, employeeDTO.getEmployee_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	
	//method 1: query 1
	//list
	public ArrayList<EmployeeDTO> getList() throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		//1. DB연결
		Connection connection = DBConnection.getConnection();
		
		//2. Query문 생성
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ,LAST_NAME, EMAIL ,PHONE_NUMBER,"
				+"HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID"
				+ " FROM EMPLOYEES";
		
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
			employeeDTO.setEamil(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			//DB의 Date타입 String도 되고, date 타입도 가능 (홑따옴표로 이미 지정되어있어서, 형식만 기억)
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));  
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
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
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME ,LAST_NAME, EMAIL ,PHONE_NUMBER,"
				+ "HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID"
				+ " FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, employee_id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEamil(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));  
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
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
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		
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
			employeeDTO.setEamil(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));  
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
		}
		
		//6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
}
