package com.techsen.friendfamilyMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techsen.friendfamilyMS.dto.FriendFamilyDTO;
import com.techsen.friendfamilyMS.service.FriendFamilyService;

@RestController
@CrossOrigin
public class FriendFamilyController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FriendFamilyService friendFamilyService;
	
	@PostMapping(value="customers/{phoneNo}/friends",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createFamilyFriend(@PathVariable long phoneNo, @RequestBody FriendFamilyDTO familyDTO) {
		logger.info("Creation request for customer {} with data {}", phoneNo, familyDTO);
		friendFamilyService.saveFamily(phoneNo, familyDTO);
	}
	
	@GetMapping(value="customers/{phoneNo}/friends",  produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<Long> getFamilyFriend(@PathVariable long phoneNo) {
		System.out.println("====Fetching Data ====");
		logger.info("Get request for family customer {}", phoneNo);
		return friendFamilyService.getSpecificFriends(phoneNo);
	}
}
