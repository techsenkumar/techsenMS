package com.techsen.customerMS.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.config.CustRibbonConfig;
import com.techsen.customerMS.dto.CustomerDTO;
import com.techsen.customerMS.dto.LoginDTO;
import com.techsen.customerMS.dto.PlanDTO;
import com.techsen.customerMS.service.CustomerService;

@RestController
@CrossOrigin
@RibbonClient(name="custribbon", configuration=CustRibbonConfig.class)
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	CustomerService custService;
	DiscoveryClient client;
	RestTemplate restTemplate;
	
	
	@Value("${friend.uri}")
	String friendURI;
	
	@Value("${plan.uri}")
	String planURI;
	
	@PostMapping(value="/customers", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createcustomer(@RequestBody CustomerDTO cust) {
		logger.info("Creation request for customer {}", cust);
		custService.createCustomer(cust);
	}
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login check for customer {} with password", loginDTO.getPhoneNo(), loginDTO.getPassword());
		return custService.login(loginDTO);
	}
	
	@GetMapping(value="/customers/{phoneNo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerDetails(@PathVariable Long phoneNo) {
		logger.info("Get customer details for customer {}", phoneNo);
		CustomerDTO custDTO = custService.getCustomerDetails(phoneNo);
		if(custDTO == null) {
			return null;
		}
		// make any MS call using REST Template
		List<ServiceInstance> instances=client.getInstances("PlanMS");
		ServiceInstance instance=instances.get(0);
		URI planUri = instance.getUri();

		PlanDTO planDTO = new RestTemplate().getForObject("http://"+planUri+"/plan/"+ custDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		custDTO.setCurrentPlan(planDTO);
		
		@SuppressWarnings("unchecked")
		List<Long> friends = restTemplate.getForObject("http://custribbon/customers/" + custDTO.getPhoneNo() + "/friends", List.class);
		custDTO.setFriendAndFamily(friends);
		return custDTO;
	}
}
