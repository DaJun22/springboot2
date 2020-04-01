package com.dj.springbootTest.modules.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.springbootTest.modules.test.dao.CountryDao;
import com.dj.springbootTest.modules.test.entity.Country;
import com.dj.springbootTest.modules.test.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService{
	@Autowired
	private CountryDao countryDao;
	@Override
	public Country getCountryById(int countryId) {
		Country country = countryDao.selectCountryById(countryId);
		return country;
	}
	@Override
	public int insertCountry(Country country) {
		int successNum = countryDao.insertCountry(country);
		return successNum;
	}

}
