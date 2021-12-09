package com.ahn.board.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// DB 계층 접근자
// JpaRepository 인터페이스를 상속받아야 메소드 사용 가능
// @Repository를 추가하지 않아도 IoC 알아서 관리 - DI 사용 가능
// JpaRepository<Entity 타입, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {

}