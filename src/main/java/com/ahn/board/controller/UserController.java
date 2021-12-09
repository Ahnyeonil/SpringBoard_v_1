package com.ahn.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/auth/user/join")
	public String userJoin() {
		return "layout/user/user_join";
	}
}
