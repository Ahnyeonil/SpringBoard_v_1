package com.ahn.board.service;

import com.ahn.board.domain.user.User;
import com.ahn.board.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
	
	// 생성자 주입을 받기 위해 @RequiredArgsConstructor 어노테이션 사용
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public Long save(User user) {
		String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPw);
		return userRepository.save(user).getId();
	}
}
