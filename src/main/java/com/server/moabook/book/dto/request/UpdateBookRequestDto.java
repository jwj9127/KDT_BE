package com.server.moabook.book.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateBookRequestDto(
        @NotNull(message = "그룹의 아이디는 비어있을 수 없습니다.")
        Long groupId,
        @NotNull(message = "책의 아이디는 비어있을 수 없습니다.")
        Long bookId,
        @NotNull(message = "책의 이름이 비어있을 수 없습니다.")
        String name
) {
}
