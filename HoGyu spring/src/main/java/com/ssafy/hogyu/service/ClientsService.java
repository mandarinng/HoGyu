package com.ssafy.hogyu.service;

import java.util.List;

import com.ssafy.hogyu.dto.Clients;

public interface ClientsService {

	List<Clients> selectAll(String productId); //전체 공동구매 리스트
	
	List<Clients> selectBuyList(String userId);  //user별 공동구매 주문정보
	
	Clients selectOne(String orderId);
	
	void update(String orderId);
	
	void insertClients(Clients clients);

}
