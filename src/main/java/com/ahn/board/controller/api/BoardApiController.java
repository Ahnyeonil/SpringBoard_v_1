package com.ahn.board.controller.api;

import com.ahn.board.config.auth.PrincipalDetail;
import com.ahn.board.dto.board.BoardSaveRequestDto;
import com.ahn.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
	
	private final BoardService boardService;
	
	/**
	 * @param boardCreateRequestDto
	 * @param principalDetail
	 * @return
	 * 
	 * 글 생성 API
	 */
	@PostMapping("/api/v1/board")
	public Long create(@RequestBody BoardSaveRequestDto boardCreateRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		return boardService.create(boardCreateRequestDto, principalDetail.getUser());
	}
	
	/**
	 * @param id
	 * @return
	 * 
	 * 글 삭제
	 */
	@DeleteMapping("/api/v1/board/{id}")
	public Long deleteById(@PathVariable Long id) {
		boardService.deleteById(id);
		return id;
	}
	
	/**
	 * @param id
	 * @param boardUpdateRequestDto
	 * @return
	 * 
	 * 글 수정
	 */
	@PutMapping("/api/v1/board/{id}")
	public Long update(@PathVariable Long id, @RequestBody BoardSaveRequestDto boardUpdateRequestDto) {
		return boardService.update(id, boardUpdateRequestDto);
	}
}
