package com.server.moabook.global.health;

import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/health")
public class HealthCheckController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public ResponseEntity<SuccessStatusResponse<Void>> healthCheck() {
        log.info("Health Check");
        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.HEALTH_CHECK_SUCCESS, null
                )
        );
    }

    @GetMapping("/token")
    public ResponseEntity<SuccessStatusResponse<Long>> tokenCheck(
            @RequestHeader("Authorization") String token
    ) {
        log.info(jwtTokenProvider.validateToken(token).toString());
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SIGNIN_SUCCESS, userId
                )
        );
    }

}
