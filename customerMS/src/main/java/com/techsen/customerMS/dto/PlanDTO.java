package com.techsen.customerMS.dto;

public class PlanDTO {	
	Integer planId;
	String planName;
	Integer localRate;
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
	public PlanDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", localRate=" + localRate + ", nationalRate="
				+ nationalRate + "]";
	}
		
}
