package com.ahn.board.controller;

//GET 요청을 받을 수 있는 이노테이션
import org.springframework.web.bind.annotation.GetMapping;
//JSON 데이터를 반환하는 컨트롤러
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello, Spring Boot!";
	}
}