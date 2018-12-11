package com.codingdojo.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.Person;
import com.codingdojo.license.repositories.LicenseRepository;
import com.codingdojo.license.repositories.PersonRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	
	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else {
			return null;
		}
		
	}
}
