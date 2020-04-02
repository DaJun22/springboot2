package com.dj.springbootTest.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dj.springbootTest.modules.test.entity.Country;
import com.dj.springbootTest.modules.test.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	CountryService cs;
	@PostMapping(value="/country", consumes="application/json")
	public Country insertCountry(@RequestBody Country country) {
		cs.insertCountry(country);
		return country;
		
	}
}
