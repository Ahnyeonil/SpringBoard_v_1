package com.ahn.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahn.board.domain.board.Board;
import com.ahn.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final BoardService boardService;
	
	@Transactional
	@GetMapping("/")
	// PageableDefault 설정은 size, 정렬을 정할 수 있다.
	public String index(Model model, @PageableDefault(size = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
			, @RequestParam(required = false, defaultValue = "") String search) {
		Page<Board> boards = boardService.findByTitleContainingOrContentContaining(search, search, pageable);
		// boards.getPageable().getPageNumber() - 현재 페이지 번호
		// startPage, endPage는 페이지 목록의 시작과 끝 페이지 번호
		int startPage = Math.max(1,  boards.getPageable().getPageNumber() - 4);
		int endPage = Math.min(boards.getTotalPages(),  boards.getPageable().getPageNumber() + 4);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boards", boards);
		return "index";
	}
}
