package com.ahn.board.user;

// JUnit5에서는 @AfterEach로 사용
// 단위 테스트 끝날 때마가 수행되는 메소드 지정.
// 여러 테스트 진행시 데이터가 남아있어서 실패의 원인이 됨.
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ahn.board.domain.user.Role;
import com.ahn.board.domain.user.User;
import com.ahn.board.domain.user.UserRepository;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@AfterEach
	public void cleanup() {
		userRepository.deleteAll();
	}
	
	@Test
	public void userJoinTest() {
		// given
		String username = "test";
		String nickname = "nickname";
		
		// insert 혹은 update 쿼리가 실행
		userRepository.save(User.builder()
				.username(username)
				.password("1234")
				.email("test@gmail.com")
				.nickname(nickname)
				.role(Role.USER)
				.build());
		
		// when
		// userRepository.findAll() - 모든 데이터를 조회
		List<User> userList = userRepository.findAll();
		
		// then
		User user = userList.get(0);
		assertThat(user.getUsername()).isEqualTo(username);
		assertThat(user.getNickname()).isEqualTo(nickname);
	}
}
