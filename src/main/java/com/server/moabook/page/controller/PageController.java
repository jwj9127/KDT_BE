package com.server.moabook.page.controller;

import com.server.moabook.page.dto.request.*;
import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import com.server.moabook.page.dto.response.SelectAllPageResponseDto;
import com.server.moabook.page.dto.response.SelectPageResponseDto;
import com.server.moabook.page.service.PageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/page")
public class PageController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PageService pageService;

    @PostMapping
    public ResponseEntity<SuccessStatusResponse<Void>> create(@RequestHeader("Authorization") String token,
                                                              @Valid @RequestBody CreatePageRequestDto createPageRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        pageService.createPage(userId, createPageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.CREATE_PAGE_SUCCESS, null
                )
        );
    }

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<SuccessStatusResponse<Void>> save(@RequestHeader("Authorization") String token,
                                                              @Valid @RequestBody SavePageRequestDto savePageRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        pageService.savePage(userId, savePageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SAVE_PAGE_SUCCESS, null
                )
        );
    }

    @GetMapping
    public ResponseEntity<SuccessStatusResponse<SelectPageResponseDto>> select(@RequestHeader("Authorization") String token,
                                                                              @Valid @RequestBody SelectPageRequestDto selectPageRequestDto){

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        SelectPageResponseDto selectBookResponseDto = pageService.selectPage(userId, selectPageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SELECT_PAGE_SUCCESS,selectBookResponseDto
                )
        );
    }

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<SuccessStatusResponse<SelectAllPageResponseDto>> selectAll(@RequestHeader("Authorization") String token,
                                                                                     @Valid @RequestBody SelectAllPageRequestDto selectAllPageRequestDto){

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        SelectAllPageResponseDto selectAllPageResponseDto = pageService.selectAllPage(userId, selectAllPageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SELECT_PAGE_SUCCESS,selectAllPageResponseDto
                )
        );
    }

    @DeleteMapping
    public ResponseEntity<SuccessStatusResponse<Void>> delete(@RequestHeader("Authorization") String token,
                                                              @Valid @RequestBody DeletePageRequestDto deletePageRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        pageService.deletePage(userId, deletePageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.DELETE_PAGE_SUCCESS, null
                )
        );
    };

}
