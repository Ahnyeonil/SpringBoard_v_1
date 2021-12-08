package com.ahn.board.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
	
	@Test
	public void lombok_test() {
		// given
		String name = "superman";
		String nickname = "hero";
		
		// when
		// 필드가 포함된 생성자
		HelloResponseDto helloResponseDto = new HelloResponseDto(name, nickname);
		
		// then
		// get 메소드 선언없이 getNname 사용 가능
		//asserThat - assertj라는 테스트 검증 라이브러리로 검증 -> isEqualTo로 값 비교
		assertThat(helloResponseDto.getName()).isEqualTo(name);
		assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
	}
}
