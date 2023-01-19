package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class LocationDAO {
	
	public int updateDate(LocationDTO locationDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS=?, POSTAL_CODE=?,CITY=?"
				+ " WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setInt(4, locationDTO.getLocation_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public int deleteData(LocationDTO locationDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, locationDTO.getLocation_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	//insert
	public int setData(LocationDTO locationDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID)"
				+ " VALUES(LOCATIONS_SEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1,locationDTO.getStreet_address());
		st.setString(2,locationDTO.getPostal_code());
		st.setString(3,locationDTO.getCity());
		st.setString(4,locationDTO.getState_province());
		st.setString(5,locationDTO.getCountry_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		//'%a%'는 %가 꼭 들어가야 됨
		st.setString(1,"%"+search+"%");
		//ResultSet에서 String은 자동으로 '' 넣어줌
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
	
	public LocationDTO getDetail(int location_id) throws Exception{
		LocationDTO locationDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, location_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}
		DBConnection.disConnect(rs, st, connection);
		return locationDTO;
	}
	
	public ArrayList<LocationDTO> getList() throws Exception{
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection connection = DBConnection.getConnection();

		//3. 0uery문 생성
		String sql = "SELECT * FROM LOCATIONS";
		
		//4. 0uery문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? 세팅
				
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();		
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
}
