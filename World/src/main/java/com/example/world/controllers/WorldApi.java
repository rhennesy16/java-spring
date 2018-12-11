package com.example.world.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.services.ApiService;

@RestController
public class WorldApi{
private final ApiService apiService;
public WorldApi(ApiService apiService) {
	this.apiService = apiService;
}
	@RequestMapping("/")
	public List<Object[]> dashboard(){
	return apiService.prob1();
	}
}
