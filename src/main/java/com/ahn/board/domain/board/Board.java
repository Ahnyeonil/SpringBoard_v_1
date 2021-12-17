package com.ahn.board.domain.board;

import com.ahn.board.domain.BaseTimeEntity;
import com.ahn.board.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
    private String title;

	// @Lob 대용량 데이터를 저장할 때 사용
	// 내용은 summernote라는 라이브러리를 사용
    @Lob
    private String content;

    private int count; //조회수

    // @ManyToOne(fetch = FetchType.EAGER) 작성자를 알기 위해 User 테이블과 조인
    // 여러 게시판과 한 명의 유저 조인
    // @JoinColumn(name = "userId") : foreign키의 컬럼명 설정
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    
    // JPA 에서 update를 진행할 때는 영속성 컨텍스트에 있는 값과 비교를 하여 변경된 값이 있을 경우 해당 값만 update
    // 이것을 변경감지, 더티체킹
    public void update(String title, String content) {
    	this.title = title;
    	this.content = content;
    }
}
