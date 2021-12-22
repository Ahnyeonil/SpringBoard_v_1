package com.ahn.board.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	// 수정 반영을 위하여 @Modifying 사용
	@Transactional
	@Modifying
	@Query("update Board p set p.count = p.count + 1 where p.id = :id")
	int updateCount(@Param("id")Long id);
	
	// Containing 키워드는 JPA LIKE 문으로 실행 - 제목이나 내용 검색
	Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
