package com.techsen.friendfamilyMS.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsen.friendfamilyMS.dto.FriendFamilyDTO;
import com.techsen.friendfamilyMS.entity.FriendFamily;
import com.techsen.friendfamilyMS.repository.FriendFamilyRepository;

@Service
public class FriendFamilyService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FriendFamilyRepository friendRepo;
	
	public void saveFamily(long phoneNo, FriendFamilyDTO familyDTO) {
		logger.info("Creation request for customer {} with data {}", phoneNo, familyDTO);
		
		familyDTO.setPhoneNo(phoneNo);
		FriendFamily friend = familyDTO.createFriend();
		friendRepo.save(friend);
		
	}
	
	// Get friend and family phone number list of a given customer
	public List<Long> getSpecificFriends(long phoneNo) {
		logger.info("Friend and family detailsfor customer {} ", phoneNo);
		List<Long> friendList= new ArrayList<>();
		List<FriendFamily> friends=friendRepo.getByphoneNo(phoneNo);
		for(FriendFamily friend: friends) {
			friendList.add(friend.getFriendAndFamily());
		}
		logger.info("The friend list is for customer{} is {} ",phoneNo,friendList);
		return friendList;
	}

}
