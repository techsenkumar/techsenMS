package com.techsen.friendfamilyMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsen.friendfamilyMS.entity.FriendFamily;

public interface FriendFamilyRepository extends JpaRepository<FriendFamily, Integer> {
	List<FriendFamily> getByphoneNo(Long phoneNo);
}
