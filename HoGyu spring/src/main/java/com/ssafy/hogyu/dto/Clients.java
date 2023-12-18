package com.ssafy.hogyu.dto;

public class Clients {
	private int id;
    private String orderId;
    private String userId;
    private String name;
    private String phoneNum;
    private String address;
    private String productId;
    private String productName;
    private int cnt;
    private int totalPrice;
    private int partner;
    
    public Clients() {
	}

	public Clients(int id, String orderId, String userId, String name, String phoneNum, String address,
			String productId, String productName, int cnt, int totalPrice, int partner) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.productId = productId;
		this.productName = productName;
		this.cnt = cnt;
		this.totalPrice = totalPrice;
		this.partner = partner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getPartner() {
		return partner;
	}

	public void setPartner(int partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", orderId=" + orderId + ", userId=" + userId + ", name=" + name + ", phoneNum="
				+ phoneNum + ", address=" + address + ", productId=" + productId + ", productName=" + productName
				+ ", cnt=" + cnt + ", totalPrice=" + totalPrice + ", partner=" + partner + "]";
	}
    

	

	
}
