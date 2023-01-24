package com.iu.main.countries;

import java.util.ArrayList;
import java.util.Scanner;

public class CountryController {
	private Scanner sc;
	private CountryDAO countryDAO;
	private CountryView countryView;
	private CountryInput countryInput;
	
	public CountryController() {
		this.sc = new Scanner(System.in);
		this.countryDAO = new CountryDAO();
		this.countryView = new CountryView();
		this.countryInput = new CountryInput();
	}
	
	public void start() throws Exception {
		ArrayList<CountryDTO> ar = null;
		CountryDTO countryDTO = null;
		boolean check = true;
		while(check) {
			System.out.println("1.나라리스트");
			System.out.println("2.나라상세정보");
			System.out.println("3.나라  검색");
			System.out.println("4.나라  추가");
			System.out.println("5.나라  삭제");
			System.out.println("6.나라  수정");
			System.out.println("7.종    료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = countryDAO.getList();
				countryView.view(ar);
				break;
			case 2:
				System.out.print("나라번호를 입력하세요: ");
				String country_id = sc.next();
				countryDTO = countryDAO.getDetail(country_id);
				if(countryDTO != null) {
					countryView.view(countryDTO);				
				}else {
					countryView.view("Data가 없다");
				}
				break;
			case 3:
				System.out.print("검색할 나라를 입력하세요: ");
				String country_name = sc.next();
				ar = countryDAO.getFind(country_name);
				countryView.view(ar);
				break;
			case 4:
				countryDTO = countryInput.setData();
				select = countryDAO.setData(countryDTO);
				if(select > 0) {
					countryView.view("추가 성공");
				}else {
					countryView.view("추가 실패");
				}
				break;
			case 5:
				countryDTO = countryInput.deleteData();
				select = countryDAO.deleteData(countryDTO);
				if(select > 0) {
					countryView.view("삭제 성공");
				}else {
					countryView.view("삭제 실패");
				}
				break;
			case 6:
				countryDTO = countryInput.setData();
				select = countryDAO.updateData(countryDTO);
				if(select > 0) {
					countryView.view("수정 성공");
				}else {
					countryView.view("수정 실패");
				}
				break;
			default:
				check = false;
			}
		}
	}
}
