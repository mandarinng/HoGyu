package com.ssafy.hogyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hogyu.dao.UserDao;
import com.ssafy.hogyu.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	@Override
	public User login(User user) {
		User tmp = dao.selectOne(user.getId());
		if(tmp != null && tmp.getPassword().equals(user.getPassword())) return tmp;
		return null;
	}
	
	@Override
	public int signup(User user) {
		return dao.insertUser(user);
	}

	@Override
	public User selectOne(String id) {
		return dao.selectOne(id);
	}


}
