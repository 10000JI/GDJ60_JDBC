package com.iu.main.regions;

import java.util.ArrayList;

public class RegionView {
	
	public void view(ArrayList<RegionDTO> ar) {
		for(RegionDTO dto : ar) {
			this.view(dto);
		}
	}
	
	public void view(RegionDTO regionDTO) {
		System.out.println("==========================");
		System.out.println("대륙번호: "+regionDTO.getRegion_id());
		System.out.println("대륙이름: "+regionDTO.getRegion_name());
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
}
