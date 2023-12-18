package com.ssafy.hogyu.dao;

import java.util.List;

import com.ssafy.hogyu.dto.Product;

public interface ProductDao {
	
	public List<Product> selectPart(String category); //목록별 리스트

	public List<Product> search(String word); //목록별 리스트
	
	public Product selectOne(String productId); //상품 하나 상세

	public Product selectName(String productId);
	
}
