package com.ssafy.hogyu.service;

import java.util.List;

import com.ssafy.hogyu.dto.Review;

public interface ReviewService {

	List<Review> getListById(String productId);//해당 제품 리뷰 전체

	Review getReview(int reviewId);//해당 제품 리뷰 상세

	void writeReview(Review review);//리뷰 작성

	void modifyReview(Review review);//리뷰 수정
	
	void removeReview(int reviewId); //리뷰 삭제
	
}
