package com.techsen.friendfamilyMS.dto;

import com.techsen.friendfamilyMS.entity.FriendFamily;

public class FriendFamilyDTO {
	long phoneNo;
	long friendAndFamily;
	
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getFriendAndFamily() {
		return friendAndFamily;
	}
	public void setFriendAndFamily(long friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}
	
	// convert DTO into Entity
	public FriendFamily createFriend() {
		FriendFamily friend = new FriendFamily();
		friend.setFriendAndFamily(this.getFriendAndFamily());
		friend.setPhoneNo(this.getPhoneNo());
		return friend;
	}
	
	
	public FriendFamilyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FriendFamilyDTO [phoneNo=" + phoneNo + ", friendAndFamily=" + friendAndFamily + "]";
	}
	
	
}
