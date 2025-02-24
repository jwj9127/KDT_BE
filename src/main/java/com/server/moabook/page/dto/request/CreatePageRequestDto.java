package com.server.moabook.page.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreatePageRequestDto(
        @NotNull(message = "책의 아이디는 비어있을 수 없습니다.")
        Long bookId
) {
}
