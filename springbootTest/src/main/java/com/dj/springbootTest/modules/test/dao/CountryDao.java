package com.dj.springbootTest.modules.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.dj.springbootTest.modules.test.entity.Country;

@Mapper
public interface CountryDao {
	@Select("select * from m_country where country_id = #{countryId}")
	public Country selectCountryById(int countryId);
	
	@Insert("INSERT INTO m_country (m_country.country_name"
			+ ",m_country.country_code)"
			+ " VALUES(#{countryName},#{countryCode})")
	@Options(useGeneratedKeys=true, keyColumn="country_id", keyProperty="countryId")
	public int insertCountry(Country country);
}
