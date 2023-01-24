package com.iu.main.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.util.DBConnection;

public class RegionDAO {
	private Scanner sc;
	
	public RegionDAO() {
		this.sc = new Scanner(System.in);
	}
	
	public ArrayList<RegionDTO> getList() throws Exception {
		ArrayList<RegionDTO> ar = new ArrayList<RegionDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT REGION_ID, REGION_NAME FROM REGIONS";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("REGION_ID"));
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
			ar.add(regionDTO);
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
	
	public RegionDTO getDetail(int region_id) throws Exception {
		RegionDTO regionDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT REGION_ID, REGION_NAME FROM REGIONS"
				+ " WHERE REGION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, region_id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("REGION_ID"));
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		DBConnection.disConnect(rs, st, connection);
		return regionDTO;
	}
	
	public ArrayList<RegionDTO> getFind(String region_name) throws Exception {
		ArrayList<RegionDTO> ar = new ArrayList<RegionDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT REGION_ID, REGION_NAME FROM REGIONS"
				+ " WHERE REGION_NAME LIKE ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, "%"+region_name+"%");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("REGION_ID"));
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
			ar.add(regionDTO);
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
	
	public int addData(RegionDTO regionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME)"
				+ " VALUES (?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public int deleteData (RegionDTO regionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, regionDTO.getRegion_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	public int updateData(RegionDTO regionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "Update REGIONS SET REGION_NAME = ?"
				+ " WHERE REGION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, regionDTO.getRegion_name());
		st.setInt(2, regionDTO.getRegion_id());
		int result = st.executeUpdate();
		return result;
	}
}
