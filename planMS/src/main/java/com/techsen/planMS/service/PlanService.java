package com.techsen.planMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsen.planMS.dto.PlanDTO;
import com.techsen.planMS.entity.Plan;
import com.techsen.planMS.respository.PlanRepository;

@Service
public class PlanService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PlanRepository planRepo;

	public List<PlanDTO> getAllPlan() {
		List<PlanDTO> planDTO = new ArrayList<>();
		List<Plan> plans = planRepo.findAll();
		for(Plan plan: plans) {
			planDTO.add(PlanDTO.valueOf(plan));
		}
		logger.info("Plan details : {}", plans);
		return planDTO;
		
		
	}

	public PlanDTO getPlanById(Integer planId) {
		PlanDTO planDTO = null;
		Optional<Plan> plan = planRepo.findById(planId);
		if(plan.isPresent()) {
			planDTO = PlanDTO.valueOf(plan.get());
		}
		return planDTO;
	}

}
