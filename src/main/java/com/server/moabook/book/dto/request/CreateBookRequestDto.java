package com.server.moabook.book.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateBookRequestDto(

        @NotNull(message = "그룹이 없을 수 없습니다.")
        Long groupId,

        @NotNull(message = "책의 이름이 비어있을 수 없습니다.")
        String name
) {
}
