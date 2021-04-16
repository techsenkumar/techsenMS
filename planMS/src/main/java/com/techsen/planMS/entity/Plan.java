package com.techsen.planMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plan {

	
	@Id
	@Column(name="plan_id", nullable=false)
	Integer planId;
	@Column(name="plan_name", nullable=false, length=50)
	String planName;
	@Column(name="local_rate", nullable=false)
	Integer localRate;
	@Column(name="national_rate", nullable=false)
	Integer nationalRate;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
