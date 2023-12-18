package com.ssafy.hogyu.dto;

public class Review {

	private int reviewId;
	private String writer; 	// 사람의 아이디.
	private String productId; // 연결된 영상의 아이디.
	private String content;
	private int star; //별점
	private String regDate;
	private String img;
	private String orgImg;

	public Review() {}

	public Review(int reviewId, String writer, String productId, String content, int star, String regDate, String img,
			String orgImg) {
		super();
		this.reviewId = reviewId;
		this.writer = writer;
		this.productId = productId;
		this.content = content;
		this.star = star;
		this.regDate = regDate;
		this.img = img;
		this.orgImg = orgImg;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", writer=" + writer + ", productId=" + productId + ", content="
				+ content + ", star=" + star + ", regDate=" + regDate + ", img=" + img + ", orgImg=" + orgImg + "]";
	}
	
	

	
	
}
