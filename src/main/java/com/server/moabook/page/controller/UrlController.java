package com.server.moabook.page.controller;

import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import com.server.moabook.page.dto.request.UrlCreateRequest;
import com.server.moabook.page.dto.response.UrlResponse;
import com.server.moabook.page.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page/{pageId}/url")
@RequiredArgsConstructor
@Slf4j
public class UrlController {

    private final UrlService urlService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<SuccessStatusResponse<UrlResponse>> createUrlElement(
            @RequestHeader("Authorization") String token,
            @PathVariable Long pageId,
            @RequestBody UrlCreateRequest request
    ) {
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        UrlResponse response = urlService.createUrlElement(userId, pageId, request);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.CREATE_BOOK_SUCCESS, response)
        );
    }

}
