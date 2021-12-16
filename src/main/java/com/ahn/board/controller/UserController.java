package com.ahn.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	/**
	 * 회원가입
	 */
	@GetMapping("/auth/user/join")
	public String userJoin() {
		return "layout/user/user_join";
	}
	
	/**
	 * 로그인
	 */
	@GetMapping("/auth/user/login")
	public String userLogin() {
		return "layout/user/user_login";
	}
	
	/**
	 * 회원수정
	 */
	@GetMapping("/user/update")
	public String userUpdate() {
		return "layout/user/user_update";
	}
}
