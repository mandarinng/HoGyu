package com.ssafy.hogyu.service;

import com.ssafy.hogyu.dto.User;


public interface UserService {

	int signup(User user); 

	User login(User user);

	User selectOne(String id);

}
