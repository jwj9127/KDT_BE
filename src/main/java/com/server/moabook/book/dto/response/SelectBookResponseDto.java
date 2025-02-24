package com.server.moabook.book.dto.response;

import com.server.moabook.book.dto.BookDto;

import java.util.List;

public record SelectBookResponseDto(
        List<BookDto> books
) {
}
