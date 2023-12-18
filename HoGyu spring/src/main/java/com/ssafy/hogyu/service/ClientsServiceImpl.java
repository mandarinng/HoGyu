package com.ssafy.hogyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hogyu.dao.ClientsDao;
import com.ssafy.hogyu.dto.Clients;

@Service
public class ClientsServiceImpl implements ClientsService {
	@Autowired
	private ClientsDao dao;

	@Override
	public List<Clients> selectAll(String productId) {
		return dao.selectAll(productId);
	}

	@Override
	public List<Clients> selectBuyList(String userId) {
		return dao.selectBuyList(userId);
	}

	@Override
	public void update(String orderId) {
		dao.update(orderId);
	}

	@Override
	public Clients selectOne(String orderId) {
		return dao.selectOne(orderId);
	}

	@Override
	public void insertClients(Clients clients) {
		dao.insertClients(clients);
		
	}

}
