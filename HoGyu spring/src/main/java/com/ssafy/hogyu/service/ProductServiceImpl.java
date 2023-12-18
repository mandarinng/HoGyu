package com.ssafy.hogyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hogyu.dao.ProductDao;
import com.ssafy.hogyu.dto.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao dao;

	@Override
	public List<Product> selectPart(String category) {
		return dao.selectPart(category);
	}

	@Override
	public List<Product> search(String word) {
		return dao.search(word);
	}

	@Override
	public Product selectOne(String productId) {
		return dao.selectOne(productId);
	}

	@Override
	public Product selectName(String productId) {
		return dao.selectName(productId);
	}

}
