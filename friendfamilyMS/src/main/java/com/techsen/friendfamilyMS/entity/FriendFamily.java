package com.techsen.friendfamilyMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friendfamily")
public class FriendFamily {

	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	int id;
	
	@Column(name="phone_no", nullable=false)
	long phoneNo;
	
	@Column(name="friend_and_family", nullable=false)
	 long friendAndFamily;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public FriendFamily() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
