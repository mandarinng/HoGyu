package com.ssafy.hogyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hogyu.dao.ClientDao;
import com.ssafy.hogyu.dto.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao dao;

	@Override
	public List<Client> selectBuyList(String userId) {
		return dao.selectBuyList(userId);
	}

	@Override
	public void insertClient(Client client) {
		dao.insertClient(client);
		
	}
	

}
