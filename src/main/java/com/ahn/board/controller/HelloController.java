package com.ahn.board.controller;

import org.springframework.web.bind.annotation.GetMapping;	// GET 요청을 받을 수 있는 이노테이션
import org.springframework.web.bind.annotation.RestController;	// JSON 데이터를 반환하는 컨트롤러

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello, Spring Boot!";
	}
}