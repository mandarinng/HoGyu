package com.ssafy.hogyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hogyu.dto.Cart;
import com.ssafy.hogyu.dto.Review;
import com.ssafy.hogyu.service.CartService;

import io.swagger.annotations.Api;

@Api(tags= {"Cart 컨트롤러"})
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestApiCartController {
	
	@Autowired
	private CartService cService;
	@PostMapping("/cart")
	public ResponseEntity<Boolean> postCart(@RequestBody Cart cart) {
		cService.insertCart(cart);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	@GetMapping("/cart/{userId}")
	public ResponseEntity<?> getCartList(@PathVariable String userId) {
		List<Cart> list = cService.selectMyCart(userId);
		return new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/cart/{cartId}")
	public ResponseEntity<Void> deleteCart(@PathVariable int cartId) {
		System.out.println(cartId);
		cService.deleteCart(cartId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
