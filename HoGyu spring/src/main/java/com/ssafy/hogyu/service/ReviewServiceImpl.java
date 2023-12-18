package com.ssafy.hogyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hogyu.dao.ReviewDao;
import com.ssafy.hogyu.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao dao;

	@Override
	public List<Review> getListById(String productId) {
		return dao.selectAll(productId);
	}

	@Override
	public Review getReview(int reviewId) {
		return dao.selectOne(reviewId);
	}

	@Override
	public void writeReview(Review review) {
		dao.insertReview(review);
	}

	@Override
	public void modifyReview(Review review) {
		dao.updateReview(review);
	}

	@Override
	public void removeReview(int reviewId) {
		dao.deleteReview(reviewId);
	}

}
