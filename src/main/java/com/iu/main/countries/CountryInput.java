package com.iu.main.countries;

import java.util.Scanner;

public class CountryInput {
	private Scanner sc;
	
	public CountryInput() {
		this.sc = new Scanner(System.in);
	}
	
	public CountryDTO setData() {
		CountryDTO countryDTO = new CountryDTO();
		System.out.print("나라번호 입력: ");
		countryDTO.setCountry_id(sc.next());
		System.out.print("나라 입력: ");
		countryDTO.setCountry_name(sc.next());
		System.out.print("대륙번호 입력: ");
		countryDTO.setNumber(sc.nextInt());
		return countryDTO;
	}
	
	public CountryDTO deleteData() {
		CountryDTO countryDTO = new CountryDTO();
		System.out.print("나라번호 입력: ");
		countryDTO.setCountry_id(sc.next());
		return countryDTO;
	}
}
