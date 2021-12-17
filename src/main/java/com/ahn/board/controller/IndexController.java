package com.ahn.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahn.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final BoardService boardService;
	
	@GetMapping("/")
	public String index(Model model) {
		//view 에 뿌려줄 모델을 파라미터로 받아서 키값을 boards 라고 한다.
		model.addAttribute("boards", boardService.findAll());
		return "index";
	}
}
