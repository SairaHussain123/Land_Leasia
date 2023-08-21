package com.candella.entity;

public class Login {
private String login_id;
public Login(String login_id, String userName, String password, String userType) {
	super();
	this.login_id = login_id;
	this.userName = userName;
	this.password = password;
	this.userType = userType;
}
public String getLogin_id() {
	return login_id;
}
public void setLogin_id(String login_id) {
	this.login_id = login_id;
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
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
private String userName;
private String password;
private String userType;
}
