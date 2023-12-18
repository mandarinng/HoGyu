package com.ssafy.hogyu.dao;

import java.util.List;

import com.ssafy.hogyu.dto.Review;

public interface ReviewDao {
	
	public List<Review> selectAll(String productId); //해당 제품 전체 리뷰

	public Review selectOne(int reviewId); //해당 제품 리뷰 한 개
	
	public void insertReview(Review review); //리뷰 작성

	public void updateReview(Review review); //리뷰 수정
	
	public void deleteReview(int reviewId);  //리뷰 삭제

}
