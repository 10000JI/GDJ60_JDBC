package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	public void view(ArrayList<LocationDTO> ar) {
		for(LocationDTO dto:ar) {
			this.view(dto);
		}
	}
	
	public void view(LocationDTO dto) {
		System.out.println("===============================");
		System.out.println("location 번호: "+dto.getLocation_id());
		System.out.println("주소: "+dto.getStreet_address());
		System.out.println("우편번호: "+ dto.getPostal_code());
		System.out.println("도시: "+ dto.getCity());
		System.out.println("주 혹은 도: "+dto.getState_province());
		System.out.println("나라 번호:" +dto.getCountry_id());
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
}
