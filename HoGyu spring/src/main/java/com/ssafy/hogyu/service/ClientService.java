package com.ssafy.hogyu.service;

import java.util.List;

import com.ssafy.hogyu.dto.Client;

public interface ClientService {
	
	public List<Client> selectBuyList(String userId);

	public void insertClient(Client client); 

	
}
