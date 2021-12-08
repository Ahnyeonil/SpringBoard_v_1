package com.ahn.board.controller;

//GET 요청을 받을 수 있는 이노테이션
import org.springframework.web.bind.annotation.GetMapping;
//JSON 데이터를 반환하는 컨트롤러
import org.springframework.web.bind.annotation.RestController;
import com.ahn.board.dto.HelloResponseDto;
// 외부에서 API로 넘긴 파라미터
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello, Spring Boot!";
	}
	
	@GetMapping("/hello/dto")
	// (@RequestParam("name"), @RequestParam("nickname")) 를 String name, String nickname 에 저장
	public HelloResponseDto helloResponseDto(@RequestParam("name")String name, @RequestParam("nickname")String nickname) {
		return new HelloResponseDto(name, nickname);
	}
}