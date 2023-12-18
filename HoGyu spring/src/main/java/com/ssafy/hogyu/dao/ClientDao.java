package com.ssafy.hogyu.dao;

import java.util.List;

import com.ssafy.hogyu.dto.Client;

public interface ClientDao {
	public List<Client> selectBuyList(String userId);  //user별 주문정보

	public void insertClient(Client client);
}
