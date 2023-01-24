package com.iu.main.regions;

import java.util.ArrayList;
import java.util.Scanner;

public class RegionController {
	private Scanner sc;
	private RegionView regionView;
	private RegionDAO regionDAO;
	private RegionInput regionInput;
	
	public RegionController() {
		this.sc = new Scanner(System.in);
		this.regionView = new RegionView();
		this.regionDAO = new RegionDAO();
		this.regionInput = new RegionInput();
	}
	
	public void start() throws Exception {
		ArrayList<RegionDTO> ar = null;
		RegionDTO regionDTO = null;
		boolean check = true;
		while(check) {
			System.out.println("1.대륙리스트");
			System.out.println("2.대륙상세정보");
			System.out.println("3.대륙  검색");
			System.out.println("4.대륙  추가");
			System.out.println("5.대륙  삭제");
			System.out.println("6.대륙  수정");
			System.out.println("7.종    료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = regionDAO.getList();
				regionView.view(ar);
				break;
			case 2:
				System.out.print("대륙 번호 입력: ");
				select = sc.nextInt();
				regionDTO = regionDAO.getDetail(select);
				if(regionDTO != null) {
					regionView.view(regionDTO);
				} else {
					regionView.view("Data가 없습니다");
				}
				break;
			case 3:
				System.out.print("대륙 검색: ");
				String region_name = sc.next();
				ar = regionDAO.getFind(region_name);
				regionView.view(ar);
				break;
			case 4:
				regionDTO = regionInput.addData();
				select = regionDAO.addData(regionDTO);
				if(select > 0) {
					regionView.view("추가 성공");
				}else {
					regionView.view("추가 실패");
				}
				break;
			case 5:
				regionDTO = regionInput.deleteData();
				select = regionDAO.deleteData(regionDTO);
				if(select > 0) {
					regionView.view("삭제 성공");
				}else {
					regionView.view("삭제 실패");
				}
				break;
			case 6:
				regionDTO = regionInput.addData();
				select = regionDAO.updateData(regionDTO);
				if(select > 0) {
					regionView.view("수정 성공");
				}else {
					regionView.view("수정 실패");
				}
				break;
			default:
				check = false;
			}
		}
	}
}
