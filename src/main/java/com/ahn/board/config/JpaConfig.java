package com.ahn.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//JPA Auditing 활성화
@EnableJpaAuditing
// Board, User 클래스에 BaseTimeEntity를 상속받으면 끝납니다.
public class JpaConfig {

}
