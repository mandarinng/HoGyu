package com.ssafy.hogyu.dto;

public class Client {
	private int id;
    private String userId;
    private String name;
    private String phoneNum;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String productId;
    private String productName;
    private int cnt;
    private int totalPrice;
    
    public Client() {
	}

	public Client(int id, String userId, String name, String phoneNum, String zipcode, String addr1, String addr2,
			String productId, String productName, int cnt, int totalPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.phoneNum = phoneNum;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.productId = productId;
		this.productName = productName;
		this.cnt = cnt;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", userId=" + userId + ", name=" + name + ", phoneNum=" + phoneNum + ", zipcode="
				+ zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", productId=" + productId + ", productName="
				+ productName + ", cnt=" + cnt + ", totalPrice=" + totalPrice + "]";
	}

	
}
