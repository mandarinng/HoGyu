package com.ssafy.hogyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hogyu.dto.Product;
import com.ssafy.hogyu.service.ProductService;

import io.swagger.annotations.Api;

@Api(tags= {"Product 컨트롤러"})
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestApiProductController {
	
	@Autowired
	private ProductService pService;
	
	// 상품 하나 
	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> getOne(@PathVariable String productId) {
		Product product = pService.selectOne(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	// 목록별 상품 리스트
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getPartList(@RequestParam String category) {
//		System.out.println("###### " + productId + " ################");
		List<Product> list = pService.selectPart(category);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	// 검색한 상품 리스트
	@GetMapping("/search/{word}")
	public ResponseEntity<List<Product>> getSearchList(@PathVariable String word){
		System.out.println("********"+word+"********");
		List<Product> list = pService.search(word);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	@GetMapping("/buying/{productId}")
	public ResponseEntity<Product> getName(@PathVariable String productId) {
		Product product = pService.selectName(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
