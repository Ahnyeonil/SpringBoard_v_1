package com.ahn.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//생성시간 및 수정시간 컬럼
//Entity 클래스마다 따로 날짜 필드를 생성하지 않아도 자동 생성 가능
@Getter
// JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 날짜 필드도 컬럼으로 인식
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
// BaseTimeEntity 클래스는 모든 Entity의 상위클래스가 되어 Entity들의 날짜 필드를 자동으로 관리
public abstract class BaseTimeEntity {

	@CreatedDate	// 생성할 때 자동저장
	private LocalDateTime createdDate;
	
	@LastModifiedDate	// 수정할 때 자동저장
	private LocalDateTime modifiedDate;
}
