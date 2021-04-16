package com.techsen.planMS.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsen.planMS.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
