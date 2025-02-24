package com.server.moabook.page.dto.request;

import com.server.moabook.page.dto.ElementDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record SavePageRequestDto(
        @NotNull(message = "책의 아이디는 비어있을 수 없습니다.")
        Long bookId,
        @NotNull(message = "페이지의 아이디는 비어있을 수 없습니다.")
        Long pageId,
        @NotNull(message = "페이지의 번호는 비어있을 수 없습니다.")
        Long pageNumber,
        @NotNull(message = "Element 정보는 비어있을 수 없습니다.")
        @Valid
        ElementDto elementDto
) {
}
