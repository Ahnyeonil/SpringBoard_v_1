package com.ahn.board.config.auth;

import com.ahn.board.domain.user.User;
import com.ahn.board.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
// @Service로 Bean으로 등록.
// UserDetailsService를 상속받게 되면 오버라이딩을 해야하는데 이 메소드는 DB에 username이 있는지 확인하는 메소드
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal =  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + username));
        // 시큐리티의 세션에 유저 정보다 저장.
        return new PrincipalDetail(principal);
    }
}