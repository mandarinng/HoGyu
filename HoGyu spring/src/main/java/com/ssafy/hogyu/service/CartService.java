package com.ssafy.hogyu.service;

import java.util.List;

import com.ssafy.hogyu.dto.Cart;

public interface CartService {
	public List<Cart> selectMyCart(String userId); // 해당 유저 장바구니 리스트

	public void insertCart(Cart cart); // 장바구니 등록

	public void deleteCart(int id); // cartId에 해당하는 장바구니 삭제

}
