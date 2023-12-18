package com.ssafy.hogyu.dao;

import java.util.List;

import com.ssafy.hogyu.dto.Clients;

public interface ClientsDao {
	
	public List<Clients> selectAll(String productId); //전체 공동구매 리스트
	
	public List<Clients> selectBuyList(String userId);  //user별 공동구매 주문정보
	
	public Clients selectOne(String orderId);
	
	public void update(String orderId);

	public void insertClients(Clients clients);

}
