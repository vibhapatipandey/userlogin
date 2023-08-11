package com.app.user.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	@Column(name="USER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	
	@Column(name="USER_FNAME", length = 50)
	private String userFName;
	
	@Column(name="USER_LNAME", length = 50)
	private String userLName;
	
	@Column(name="USER_DOB")
	private String userDOB;
	
	@Column(name="USERNAME", length = 15)
	private String userName;
	
	@Column(name="PASSWORD",nullable = false, length = 40)
	private String password;
	
	@Column(name="USER_DPT_NAME",length = 20)
	private String dptName;
	
	@Column(name="USER_TRAINING_NAME",length = 30)
	private String traningName;
	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(String userDOB) {
		this.userDOB = userDOB;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getTraningName() {
		return traningName;
	}

	public void setTraningName(String traningName) {
		this.traningName = traningName;
	}

	
	

}
