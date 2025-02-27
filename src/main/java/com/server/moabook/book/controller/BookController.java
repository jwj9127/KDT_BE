package com.server.moabook.book.controller;

import com.server.moabook.book.dto.request.CreateBookRequestDto;
import com.server.moabook.book.dto.request.DeleteBookRequestDto;
import com.server.moabook.book.dto.request.UpdateBookRequestDto;
import com.server.moabook.book.dto.response.SelectBookResponseDto;
import com.server.moabook.book.service.BookService;
import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final JwtTokenProvider jwtTokenProvider;
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<SuccessStatusResponse<Void>> create(@RequestHeader("Authorization") String token,
                                                                                @Valid @RequestBody CreateBookRequestDto createBookRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        bookService.createBook(userId, createBookRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.CREATE_BOOK_SUCCESS, null
                )
        );
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<SuccessStatusResponse<SelectBookResponseDto>> select(@RequestHeader("Authorization") String token,
                                                                                    @Valid @PathVariable("groupId") Long groupId){

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        SelectBookResponseDto selectBookResponseDto = bookService.selectBook(userId, groupId);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SELECT_BOOK_SUCCESS,selectBookResponseDto
                )
        );
    }

    @PutMapping
    public ResponseEntity<SuccessStatusResponse<Void>> update(@RequestHeader("Authorization") String token,
                                                              @Valid @RequestBody UpdateBookRequestDto updateBookRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        bookService.updateBook(userId, updateBookRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.UPDATE_BOOK_SUCCESS, null
                )
        );
    };

    @DeleteMapping
    public ResponseEntity<SuccessStatusResponse<Void>> delete(@RequestHeader("Authorization") String token,
                                                                                @Valid @RequestBody DeleteBookRequestDto deleteBookRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        bookService.deleteGroup(userId, deleteBookRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.DELETE_BOOK_SUCCESS, null
                )
        );
    };

}
