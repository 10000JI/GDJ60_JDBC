package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {
	private Scanner sc;
	
	public LocationInput() {
		this.sc = new Scanner(System.in);
	}
	
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.print("location 번호 입력:");
		locationDTO.setLocation_id(sc.nextInt());
		System.out.print("주소 입력: ");
		locationDTO.setStreet_address(sc.next());
		System.out.print("우편번호 입력: ");
		locationDTO.setPostal_code(sc.next());
		System.out.print("도시 입력: ");
		locationDTO.setCity(sc.next());
		return locationDTO;
	}
	
	//추가
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.print("주소 입력: ");
		locationDTO.setStreet_address(sc.next());
		System.out.print("우편번호 입력: ");
		locationDTO.setPostal_code(sc.next());
		System.out.print("도시 입력: ");
		locationDTO.setCity(sc.next());
		System.out.print("주 혹은 도 입력: ");
		locationDTO.setState_province(sc.next());
		System.out.print("나라번호 입력: ");
		locationDTO.setCountry_id(sc.next());
		return locationDTO;
	}
	
	//삭제
	public LocationDTO deleteData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.print("location번호 입력: ");
		locationDTO.setLocation_id(sc.nextInt());
		return locationDTO;
	}
}
