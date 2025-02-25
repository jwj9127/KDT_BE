package com.server.moabook.page.controller;

import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import com.server.moabook.page.dto.request.TextCreateRequest;
import com.server.moabook.page.dto.request.TextUpdateRequest;
import com.server.moabook.page.dto.response.TextResponse;
import com.server.moabook.page.service.TextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page/{pageId}/text")
@RequiredArgsConstructor
@Slf4j
public class TextController {

    private final TextService textService;
    private final JwtTokenProvider jwtTokenProvider;

    // 텍스트 생성
    @PostMapping
    public ResponseEntity<SuccessStatusResponse<TextResponse>> createText(
            @RequestHeader("Authorization") String token,
            @PathVariable Long pageId,
            @RequestBody TextCreateRequest request
    ) {
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        TextResponse response = textService.createText(userId, pageId, request);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.CREATE_TEXT_SUCCESS, response)
        );
    }

    // 텍스트 조회
    @GetMapping("/{elementId}")
    public ResponseEntity<SuccessStatusResponse<TextResponse>> getText(
            @RequestHeader("Authorization") String token,
            @PathVariable Long pageId,
            @PathVariable Long elementId
    ) {
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        TextResponse response = textService.getText(userId, elementId);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.SELECT_TEXT_SUCCESS, response)
        );
    }

    // 텍스트 수정
    @PutMapping("/{elementId}")
    public ResponseEntity<SuccessStatusResponse<TextResponse>> updateText(
            @RequestHeader("Authorization") String token,
            @PathVariable Long pageId,
            @PathVariable Long elementId,
            @RequestBody TextUpdateRequest request
    ) {
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        TextResponse response = textService.updateText(userId, elementId, request);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.UPDATE_TEXT_SUCCESS, response)
        );
    }

    // 텍스트 삭제
    @DeleteMapping("/{elementId}")
    public ResponseEntity<SuccessStatusResponse<Void>> deleteText(
            @RequestHeader("Authorization") String token,
            @PathVariable Long pageId,
            @PathVariable Long elementId
    ) {
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        textService.deleteText(userId, elementId);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.DELETE_TEXT_SUCCESS, null)
        );
    }

    // 페이지에 있는 모든 텍스트 조회
    @GetMapping
    public ResponseEntity<SuccessStatusResponse<List<TextResponse>>> getAllTexts(
            @RequestHeader("Authorization") String token,
            @PathVariable Long pageId
    ) {
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        List<TextResponse> responseList = textService.getAllTextsInPage(userId, pageId);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.SELECT_TEXT_SUCCESS, responseList)
        );
    }

}