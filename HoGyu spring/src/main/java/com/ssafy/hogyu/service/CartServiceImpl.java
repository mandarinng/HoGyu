package com.ssafy.hogyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hogyu.dao.CartDao;
import com.ssafy.hogyu.dto.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao;

	@Override
	public List<Cart> selectMyCart(String userId) {
		return dao.selectMyCart(userId);
	}

	@Override
	public void insertCart(Cart cart) {
		dao.insertCart(cart);
	}

	@Override
	public void deleteCart(int id) {
		dao.deleteCart(id);
	}

}
