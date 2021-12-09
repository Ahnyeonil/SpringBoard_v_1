package com.ahn.board.controller.api;

import com.ahn.board.dto.user.UserJoinRequestDto;
import com.ahn.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        return userService.save(userJoinRequestDto.toEntity());
    }
}