package com.techsen.customerMS.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsen.customerMS.dto.CustomerDTO;
import com.techsen.customerMS.dto.LoginDTO;
import com.techsen.customerMS.entity.Customer;
import com.techsen.customerMS.repository.CustomerRepository;

@Service
public class CustomerService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository custRepo;

	public void createCustomer(CustomerDTO custDTO) {
		logger.info("Service: Creation request for customer {}", custDTO);
		Customer cust = custDTO.createEntity();
		custRepo.save(cust);
		
	}

	public boolean login(LoginDTO loginDTO) {
		Customer cust = null;
		logger.info("Service: Login check for customer {} with password", loginDTO.getPhoneNo(), loginDTO.getPassword());
		Optional<Customer> optCust = custRepo.findById(loginDTO.getPhoneNo());
		if(optCust.isPresent()) {
			cust = optCust.get();
			if(cust.getPassword().equals(loginDTO.getPassword())) {
				return true;
			}
			return false;
		}
		return false;
	}

	public CustomerDTO getCustomerDetails(Long phoneNo) {
		CustomerDTO custDTO = null;
		logger.info("Service: Get customer details for customer {}", phoneNo);
		Optional<Customer> optCust = custRepo.findById(phoneNo);
		if(optCust.isPresent()) {
			Customer cust = optCust.get();
			custDTO = CustomerDTO.valueOf(cust);
		}
		logger.info("Profile for customer : {}", custDTO);
		return custDTO;
	}

}
