package main;

import java.sql.Date;

public class User {
	
	private String UserID, UserName, UserEmail, UserPassword, UserDOB, UserGender, UserAddress;
	private int UserPhone;
	private String UserRole;
	

	public User(String userID, String userName, String userEmail, String userPassword, String userDOB,
			String userGender, String userAddress, int userPhone, String userRole) {
		UserID = userID;
		UserName = userName;
		UserEmail = userEmail;
		UserPassword = userPassword;
		UserDOB = userDOB;
		UserGender = userGender;
		UserAddress = userAddress;
		UserPhone = userPhone;
		UserRole = userRole;
	}







	public String getUserID() {
		return UserID;
	}







	public void setUserID(String userID) {
		UserID = userID;
	}







	public String getUserName() {
		return UserName;
	}







	public void setUserName(String userName) {
		UserName = userName;
	}







	public String getUserEmail() {
		return UserEmail;
	}







	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}







	public String getUserPassword() {
		return UserPassword;
	}







	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}







	public String getUserDOB() {
		return UserDOB;
	}







	public void setUserDOB(String userDOB) {
		UserDOB = userDOB;
	}







	public String getUserGender() {
		return UserGender;
	}







	public void setUserGender(String userGender) {
		UserGender = userGender;
	}







	public String getUserAddress() {
		return UserAddress;
	}







	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}







	public int getUserPhone() {
		return UserPhone;
	}







	public void setUserPhone(int userPhone) {
		UserPhone = userPhone;
	}







	public String getUserRole() {
		return UserRole;
	}







	public void setUserRole(String userRole) {
		UserRole = userRole;
	}







	public User() {
		
	}

}
