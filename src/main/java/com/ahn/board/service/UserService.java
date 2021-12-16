package com.ahn.board.service;

import com.ahn.board.config.auth.PrincipalDetail;
import com.ahn.board.domain.user.User;
import com.ahn.board.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
	
	// 생성자 주입을 받기 위해 @RequiredArgsConstructor 어노테이션 사용
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * @param user
	 * 회원가입 로직
	 * @return
	 */
	@Transactional
	public Long join(User user) {
		String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPw);
		return userRepository.save(user).getId();
	}
	
	// Service 에서는 먼저 User 객체를 영속화 시켜야 한다.
	// JPA를 사용하면 영속성 컨텍스트가 메모리에 뜨는데따로 update 쿼리문을 날리지 않아도 1차 캐시에
	// 있는 데이터에서 변경이 감지되면 알아서 update를 시켜준다
	// 변경이 감지되는 것을 더티체킹이라고 한다.
	// 영속화된 userEntity에 변경된 데이터를 넣어주면 된다.
	@Transactional
	public Long update(User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		User userEntity = userRepository.findById(user.getId()).orElseThrow(()
				-> new IllegalArgumentException("해당 회원이 없습니다. id=" + user.getId()));
		userEntity.update(bCryptPasswordEncoder.encode(user.getPassword()), user.getEmail(), user.getNickname());
		principalDetail.setUser(userEntity);
		
		return userEntity.getId();
	}
}
