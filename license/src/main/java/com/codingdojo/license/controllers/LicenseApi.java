package com.codingdojo.license.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.Person;
import com.codingdojo.license.services.LicenseService;

@RestController
public class LicenseApi {
	private final LicenseService licenseService;
	
	public LicenseApi(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	@RequestMapping("/api/license")
	public List<License> index(){
		return licenseService.allLicenses();
	}
    @RequestMapping(value="/api/license", method=RequestMethod.POST)
    public License create(@RequestParam(value="firstName") String firstName, 
    					  @RequestParam(value="lastName") String lastName, 
    					  @RequestParam(value="number") String number,  
    					  @RequestParam(value="state") String state) {
    	Person person = new Person(firstName, lastName);
        License license = new License(number, state, person);
        licenseService.createPerson(person);
        return licenseService.createLicense(license);
        
    }
}
