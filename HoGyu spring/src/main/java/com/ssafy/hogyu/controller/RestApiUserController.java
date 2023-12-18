package com.ssafy.hogyu.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hogyu.dto.User;
import com.ssafy.hogyu.service.UserService;

import io.swagger.annotations.Api;

@Api(tags= {"User 컨트롤러"})
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestApiUserController {

	@Autowired
	private UserService uService;

//	@Autowired
//	private ReviewService rService;

	// 회원가입
	@PostMapping("/user")
	public ResponseEntity<Boolean> postUser(@RequestBody User user) {
		if (uService.signup(user) == 1)
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_IMPLEMENTED);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getOne(@PathVariable String userId) {
		User user = uService.selectOne(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		System.out.println("############################# " + user.getId());

		User tmp = uService.login(user);
		if (tmp == null)
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}

	@GetMapping("/user/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
