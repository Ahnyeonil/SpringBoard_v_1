package com.ahn.board.controller.api;

import com.ahn.board.config.auth.PrincipalDetail;
import com.ahn.board.domain.user.User;
import com.ahn.board.dto.user.UserJoinRequestDto;
import com.ahn.board.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    /**
     * @param userJoinRequestDto
     * 회원가입 API
     * @return
     */
    @PostMapping("/auth/api/v1/user")
    public Long join(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        return userService.join(userJoinRequestDto.toEntity());
    }
    
    /**
     * @param user
     * 회원수정 API
     * @return
     */
    @PutMapping("/api/v1/user")
    public Long update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
    	return userService.update(user, principalDetail);
    }
}