package com.ssafy.hogyu.dto;

public class Cart {

	    private int id;
	    private String productId;
	    private String productName;
	    private int cnt;
	    private int price;
	    private String img;
	    private String userId;

	    public Cart() {
	        // 기본 생성자
	    }

		public Cart(int id, String productId, String productName, int cnt, int price, String img, String userId) {
			super();
			this.id = id;
			this.productId = productId;
			this.productName = productName;
			this.cnt = cnt;
			this.price = price;
			this.img = img;
			this.userId = userId;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		@Override
		public String toString() {
			return "Cart [id=" + id + ", productId=" + productId + ", productName=" + productName + ", cnt=" + cnt
					+ ", price=" + price + ", img=" + img + ", userId=" + userId + "]";
		}

	    
	    
	
	
}
