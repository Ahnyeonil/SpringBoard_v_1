package com.ahn.board.controller;

import com.ahn.board.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.is;

// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
@ExtendWith(SpringExtension.class)
// Web에 집중할 수 있는 이노테이션
@WebMvcTest(controllers = HelloController.class,
excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
})
public class HelloControllerTest {

	// 스프링이 관리하는 빈을 주입 받는다.
	@Autowired
	// MockMvc - 웹 API를 테스트할 때 사용합니다. 
	private MockMvc mvc;
	
	@Test
	public void hello_Test() throws Exception {
		String hello = "hello, Spring Boot!";
		
		mvc.perform(get("/hello"))
				// .andExpect(status().isOk()) - HTTP Header의 상태코드
				.andExpect(status().isOk())
				// .andExpect(content().string(hello)) - mvc.perform의 결과를 알려줌
				.andExpect(content().string(hello));

	}
	
	@Test
	public void helloDto_Test() throws Exception {
		String name = "superman";
		String nickname = "hero";
		
		mvc.perform(
			get("/hello/dto")
				.param("name",  name)
				.param("nickname", nickname))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.nickname", is(nickname)));
	}

}
