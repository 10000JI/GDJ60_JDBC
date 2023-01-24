package com.iu.main.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.employees.EmployeeDTO;
import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class CountryDAO {
	public ArrayList<CountryDTO> getList() throws Exception {
		ArrayList<CountryDTO> ar = new ArrayList<CountryDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setNumber(rs.getInt("REGION_ID"));
			ar.add(countryDTO);
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
	
	public CountryDTO getDetail(String country_id) throws Exception {
		CountryDTO countryDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES"
				+ " WHERE COUNTRY_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, country_id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			countryDTO = new CountryDTO();
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setNumber(rs.getInt("REGION_ID"));
		}
		DBConnection.disConnect(st, connection);
		return countryDTO;
	}
	
	public ArrayList<CountryDTO> getFind(String country_name) throws Exception {
		ArrayList<CountryDTO> ar = new ArrayList<CountryDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES"
				+ " WHERE COUNTRY_NAME LIKE ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, "%"+country_name+"%");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setNumber(rs.getInt("REGION_ID"));
			ar.add(countryDTO);
		}
		DBConnection.disConnect(st, connection);
		return ar;
	}
	
	public int setData(CountryDTO countryDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID)"
				+ " VALUES (?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, countryDTO.getCountry_id());
		st.setString(2, countryDTO.getCountry_name());
		st.setInt(3, countryDTO.getNumber());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public int deleteData(CountryDTO countryDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE COUNTRIES WHERE COUNTRY_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, countryDTO.getCountry_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public int updateData(CountryDTO countryDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE COUNTRIES SET COUNTRY_NAME=?,REGION_ID=?"
				+ " WHERE COUNTRY_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, countryDTO.getCountry_name());
		st.setInt(2, countryDTO.getNumber());
		st.setString(3,countryDTO.getCountry_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result; 
	}
}
