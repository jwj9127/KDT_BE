package com.server.moabook.user.controller;

import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import com.server.moabook.user.dto.response.SelectUserResponseDto;
import com.server.moabook.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<SuccessStatusResponse<SelectUserResponseDto>> select(@RequestHeader("Authorization") String token) {

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        SelectUserResponseDto selectUserResponseDto = userService.select(userId);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SELECT_USER_SUCCESS, selectUserResponseDto
                )
        );
    }

    @DeleteMapping
    public ResponseEntity<SuccessStatusResponse<Void>> delete(@RequestHeader("Authorization") String token) {

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        userService.delete(userId);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.DELETE_USER_SUCCESS, null
                )
        );
    }

    @DeleteMapping
    @RequestMapping("/all")
    public ResponseEntity<SuccessStatusResponse<Void>> deleteAll(@RequestHeader("Authorization") String token) {

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        userService.deleteAll(userId);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.DELETE_ALL_USER_SUCCESS, null
                )
        );
    }

    @PatchMapping
    public ResponseEntity<SuccessStatusResponse<Void>> updateReceivedEmail(
            @RequestHeader("Authorization") String token,
            @RequestParam(value = "user_email", required = false) String email,
            @RequestParam("is_received_email") boolean checkReceivedEmail) {

        Long userId = jwtTokenProvider.getUserFromJwt(token);

        userService.updateReceivedEmail(userId, email, checkReceivedEmail);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.UPDATE_RECEIVED_EMAIL_SUCCESS, null
                )
        );
    }

}