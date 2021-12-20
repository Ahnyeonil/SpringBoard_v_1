package com.ahn.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ahn.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	/**
	 * @return
	 * 
	 * 글 등록 페이지 이동
	 */
	@GetMapping("/board/create")
	public String create() {
		return "layout/board/board_create";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 * 
	 * 글 상세 페이지 이동
	 */
	@GetMapping("/board/{id}")
	public String detail(@PathVariable Long id, Model model) {
		model.addAttribute("board", boardService.detail(id));
	    return "layout/board/board_detail";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 * 
	 * 글 수정 페이지 이동
	 */
	@GetMapping("/board/{id}/update")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("board", boardService.detail(id));
		return "layout/board/board_update";
	}
}