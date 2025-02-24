package com.server.moabook.page.dto.response;

import com.server.moabook.page.dto.ElementDto;

import java.util.List;

public record SelectPageResponseDto(
        List<ElementDto> elements
) {
}
