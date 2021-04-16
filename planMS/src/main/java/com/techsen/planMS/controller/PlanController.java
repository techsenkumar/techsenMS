package com.techsen.planMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techsen.planMS.dto.PlanDTO;
import com.techsen.planMS.service.PlanService;

@RestController
@CrossOrigin
public class PlanController {

	@Autowired
	PlanService planService;
	DiscoveryClient client;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/plans", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans(){
		logger.info("Get all the plan details");
		return planService.getAllPlan();
	}
	
	@GetMapping(value="/plan/{planId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getPlanById(@PathVariable Integer planId) {
		logger.info("Get paln by id {}", planId);
		return planService.getPlanById(planId);		
	}
}
