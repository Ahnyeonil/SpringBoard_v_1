package com.ahn.board.service;

import com.ahn.board.domain.board.Board;
import com.ahn.board.domain.board.BoardRepository;
import com.ahn.board.domain.user.User;
import com.ahn.board.dto.board.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	/**
	 * @param boardCreateRequestDto
	 * @param user
	 * @return
	 * 
	 * 글 생성
	 */
	@Transactional
	public Long create(BoardSaveRequestDto boardCreateRequestDto, User user) {
		boardCreateRequestDto.setUser(user);
		return boardRepository.save(boardCreateRequestDto.toEntity()).getId();
	}
	
	/**
	 * @param id
	 * @return
	 * 
	 * 글 상세
	 */
	 @Transactional(readOnly = true)
	 public Board detail(Long id) {
	     return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
	 }
	
	/**
	 * @return
	 * 
	 * 글 목록
	 */
	//JPA 의 findAll() 메소드를 사용하면 테이블의 raw 데이터를 모두 조회
	public List<Board> findAll() {
		return boardRepository.findAll();
	}

	/**
	 * @param id
	 * 
	 * 글 삭제
	 */
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
	
	/**
	 * @param id
	 * @param boardUpdateRequestDto
	 * @return
	 * 
	 * 글 수정
	 */
	@Transactional
	public Long update(Long id, BoardSaveRequestDto boardUpdateRequestDto) {
		Board board = boardRepository.findById(id).orElseThrow(()
				-> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
		board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
		return id;
	}
}
