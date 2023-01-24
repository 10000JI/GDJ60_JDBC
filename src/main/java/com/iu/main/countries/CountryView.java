package com.iu.main.countries;

import java.util.ArrayList;

public class CountryView {
	public void view(ArrayList<CountryDTO> ar) {
		for(CountryDTO countryDTO: ar) {
			this.view(countryDTO);
		}
	}
	
	public void view(CountryDTO countryDTO) {
		System.out.println("====================================");
		System.out.println("나라번호: "+countryDTO.getCountry_id());
		System.out.println("나라이름: "+countryDTO.getCountry_name());
		System.out.println("대륙번호: "+countryDTO.getNumber());
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
}
