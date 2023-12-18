package com.ssafy.hogyu.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private String phoneNum;
	private String address;

	public User() { }
	


	public User(String id, String password, String name, String phoneNum, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", phoneNum=" + phoneNum + ", address="
				+ address + "]";
	}
}
