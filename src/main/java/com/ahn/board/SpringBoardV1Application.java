package com.ahn.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
// @SpringBootApplication 역할
// 메인 클래스 명시
// 스트링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
// 설정을 읽은 시작점으로 프로젝트 최상단에 위치
public class SpringBoardV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoardV1Application.class, args);	// 내장 WAS 실행
	}
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
