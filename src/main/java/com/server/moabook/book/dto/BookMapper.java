package com.server.moabook.book.dto;

import com.server.moabook.book.domain.Book;
import com.server.moabook.book.dto.request.CreateBookRequestDto;
import com.server.moabook.book.dto.request.UpdateBookRequestDto;
import com.server.moabook.book.dto.response.SelectBookResponseDto;
import com.server.moabook.group.domain.Group;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static Book toEntity(CreateBookRequestDto createBookRequestDto, Group group) {
        return Book.builder()
                .name(createBookRequestDto.name())
                .group(group)
                .build();
    }

    public static SelectBookResponseDto toDTO(List<Book> books) {
        List<BookDto> bookDtos = books.stream()
                .map(book -> new BookDto(book.getId(), book.getName()))
                .collect(Collectors.toList());
        return new SelectBookResponseDto(bookDtos);
    }

    public static void update(Book book, UpdateBookRequestDto updateBookRequestDto) {
        book.changeName(updateBookRequestDto.name());
    }

}
