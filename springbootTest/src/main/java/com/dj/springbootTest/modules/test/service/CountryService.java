package com.dj.springbootTest.modules.test.service;

import com.dj.springbootTest.modules.test.entity.Country;

public interface CountryService {
	public Country getCountryById(int countryId);
	
	public int insertCountry(Country country);
}
