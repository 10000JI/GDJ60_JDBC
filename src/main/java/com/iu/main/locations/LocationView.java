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
		System.out.println("지역번호: "+dto.getLocation_id());
		System.out.println("거주지: "+dto.getStreet_address());
		System.out.println("우편번호: "+ dto.getPostal_code());
		System.out.println("도시: "+ dto.getCity());
		System.out.println("국가사회: "+dto.getState_province());
		System.out.println("나라번호:" +dto.getCountry_id());
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
}
