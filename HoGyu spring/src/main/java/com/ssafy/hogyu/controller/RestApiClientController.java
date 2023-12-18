package com.ssafy.hogyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hogyu.dto.Client;
import com.ssafy.hogyu.dto.Clients;
import com.ssafy.hogyu.service.ClientService;
import com.ssafy.hogyu.service.ClientsService;

import io.swagger.annotations.Api;

@Api(tags= {"Client 컨트롤러"})
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestApiClientController {
	
	@Autowired
	private ClientService cService;
	
	@Autowired
	private ClientsService csService;
	
	@GetMapping("/order/{userId}") //해당 유저의 혼자구매내역 리스트
	public ResponseEntity<List<Client>> getClientBuyList(@PathVariable String userId){
		System.out.println("********"+userId+"********");
		List<Client> list = cService.selectBuyList(userId);
		return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
	}
	@GetMapping("/orders/{userId}") //해당 유저의 공동구매내역 리스트
	public ResponseEntity<List<Clients>> getClientsBuyList(@PathVariable String userId){
		List<Clients> list = csService.selectBuyList(userId);
		return new ResponseEntity<List<Clients>>(list, HttpStatus.OK);
	}
	@GetMapping("/clients")
	public ResponseEntity<List<Clients>> getClientsList(@RequestParam String productId){
		List<Clients> list = csService.selectAll(productId);
		return new ResponseEntity<List<Clients>>(list, HttpStatus.OK);
	}
	@PutMapping("/clients/{orderId}")
	public ResponseEntity<Void> updateReview(@PathVariable String orderId) {
		csService.update(orderId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	//주문번호에 맞는 주문 1개 가져오기
	@GetMapping("/clients/{orderId}") 
	public ResponseEntity<Clients> getOne(@PathVariable String orderId) {
		Clients clients = csService.selectOne(orderId);
		return new ResponseEntity<Clients>(clients, HttpStatus.OK);
	}
	//공동구매등록
	@PostMapping("/clients")
	public ResponseEntity<?> insertClients(@RequestBody Clients clients) {
		csService.insertClients(clients);
		return new ResponseEntity<Clients>(clients, HttpStatus.OK);
	}
	//개별구매 등록
	@PostMapping("/client")
	public ResponseEntity<?> insertClient(@RequestBody Client client) {
		cService.insertClient(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	

}
