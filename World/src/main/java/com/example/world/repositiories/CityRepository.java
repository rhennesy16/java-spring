package com.example.world.repositiories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.world.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
