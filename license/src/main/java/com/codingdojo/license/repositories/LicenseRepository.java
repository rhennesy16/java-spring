package com.codingdojo.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.license.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
}
