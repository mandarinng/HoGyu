package com.ssafy.hogyu.dao;

import com.ssafy.hogyu.dto.User;


public interface UserDao {

	int insertUser(User user); //회원 가입
	
	User selectOne(String id); //로그인
	
}
