package com.ssafy.hogyu.service;

import java.util.List;

import com.ssafy.hogyu.dto.Product;

public interface ProductService {
	
	public List<Product> selectPart(String category); //목록별 리스트

	public List<Product> search(String word); //목록별 리스트
	
	public Product selectOne(String productId); //상품 하나 상세

	public Product selectName(String productId);

}
