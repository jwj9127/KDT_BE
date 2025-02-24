package com.server.moabook.page.dto;

import java.util.List;

public record PageDto(
        Long pageId,
        Long pageNumber,
        List<ElementDto> elements
) {
}