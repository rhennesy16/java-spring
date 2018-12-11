package com.example.ninjagold.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ninjagold.models.ninja;

@Repository
public interface NinjaRepository extends CrudRepository<ninja,Integer>{
}
