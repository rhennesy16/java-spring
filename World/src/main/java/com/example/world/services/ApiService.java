package com.example.world.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.world.models.Language;
import com.example.world.repositiories.CityRepository;
import com.example.world.repositiories.CountryRepository;
import com.example.world.repositiories.LanguageRepository;

@Service
public class ApiService {
	
private final CountryRepository countryRepository;	
private final CityRepository cityRepository;	
private final LanguageRepository languageRepository;


	public ApiService(CountryRepository countryRepository, CityRepository cityRepository, LanguageRepository languageRepository) {
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
		this.languageRepository = languageRepository;
	}
	public List<Object[]> prob1(){
		return countryRepository.query1();
	}
}
