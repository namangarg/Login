package com.registration.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {

	public User(int id, int otp, String phonenumber) {
		this.id = id;
		this.otp = otp;
		this.phonenumber = phonenumber;
	}

	private int id;
	private int otp;
	//private UserInfo userInfo;
	private String phonenumber;


	public User() {

	}

/*
	@OneToOne(mappedBy = "userInfo")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
*/

	@NotNull(message = "OTP cannot be empty")
	@Column(name = "otp")
	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	public int geId() {
		return id;
	}

	public void setId(int id) {
		this.id =id;
	}

	@Column(name = "phonenumber")
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}