package com.iu.main.regions;

import java.util.Scanner;

public class RegionInput {
	private Scanner sc;
	
	public RegionInput() {
		this.sc = new Scanner(System.in);
	}
	
	public RegionDTO addData() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.print("대륙번호 입력: ");
		regionDTO.setRegion_id(sc.nextInt());
		System.out.print("대륙 입력: ");
		regionDTO.setRegion_name(sc.next());
		return regionDTO;
	}
	
	public RegionDTO deleteData() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.print("대륙번호 입력: ");
		regionDTO.setRegion_id(sc.nextInt());
		return regionDTO;
	}
}
