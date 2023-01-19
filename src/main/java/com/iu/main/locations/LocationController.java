package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	
	public LocationController() {
		this.sc = new Scanner(System.in);
		this.locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		this.locationInput = new LocationInput();
	}
	
	public void start() throws Exception {
		boolean check = true;
		ArrayList<LocationDTO> ar = null;
		LocationDTO locationDTO = null;;
		
		while(check) {
			System.out.println("1.주소 리스트");
			System.out.println("2.주소 상세정보");
			System.out.println("3.주소 검색");
			System.out.println("4.주소 추가");
			System.out.println("5.주소 삭제");
			System.out.println("6.주소 수정");
			System.out.println("7.종료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.print("location 번호를 입력하세요: ");
				select = sc.nextInt();
				locationDTO = locationDAO.getDetail(select);
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("Data가 없습니다.");
				}
				break;
			case 3:
				System.out.print("검색할 주소 입력: ");
				String add = sc.next();
				ar = locationDAO.getFind(add);
				locationView.view(ar);
				break;
			case 4:
				locationDTO = locationInput.setData();
				select = locationDAO.setData(locationDTO);
				String msg = "추가 실패";
				if(select>0) {
					msg = "추가 성공";
				}
				locationView.view(msg);
				break;
			case 5:
				locationDTO = locationInput.deleteData();
				select = locationDAO.deleteData(locationDTO);
				if(select > 0) {
					locationView.view("삭제 성공");
				}else {
					locationView.view("삭제 실패");				
				}
				break;
			case 6:
				locationDTO = locationInput.updateData();
				select = locationDAO.updateDate(locationDTO);
				if(select > 0) {
					locationView.view("수정 성공");
				}else {
					locationView.view("수정 실패");				
				}
				break;
			default:
				check = false;
			}
		}
	}
}
