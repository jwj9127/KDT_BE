package com.server.moabook.page.dto.response;

import com.server.moabook.page.dto.PageDto;

import java.util.List;

public record SelectAllPageResponseDto (
        List<PageDto> pages
) {
}