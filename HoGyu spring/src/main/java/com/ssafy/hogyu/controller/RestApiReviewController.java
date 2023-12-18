package com.ssafy.hogyu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.hogyu.dto.Review;
import com.ssafy.hogyu.service.ReviewService;

import io.swagger.annotations.Api;

@Api(tags= {"Review 컨트롤러"})
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestApiReviewController {

	@Autowired
	private ReviewService rService;
	
	@Autowired
	private ResourceLoader resLoader;
	
	// productId에 맞는 제품 리스트 출력
	@GetMapping("/review")
	public ResponseEntity<List<Review>> getList(@RequestParam String productId) {
//		System.out.println("###### " + productId + " ################");
		List<Review> list = rService.getListById(productId);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

	@GetMapping("/review/{reviewId}")
	public ResponseEntity<Review> getOne(@PathVariable int reviewId) {
		Review review = rService.getReview(reviewId);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	@PostMapping("/review")
	public ResponseEntity<Boolean> postReview(@ModelAttribute Review review, @RequestParam(required=false) MultipartFile file) throws IllegalStateException, IOException {
		
		if(file != null && file.getSize() > 0) {
			Resource res = resLoader.getResource("classpath:/static/upload");
			review.setImg(System.currentTimeMillis()+"_"+file.getOriginalFilename());
			review.setOrgImg(file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalFile()+"/"+review.getImg()));
		}
		
		rService.writeReview(review);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//		return null;
	}

	@PutMapping("/review")
	public ResponseEntity<Void> updateReview(@RequestBody Review review) {
		System.out.println(review);
		rService.modifyReview(review);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/review/{reviewId}")
	public ResponseEntity<Void> deleteReview(@PathVariable int reviewId) {
		System.out.println(reviewId);
		rService.removeReview(reviewId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
