package com.server.moabook.page.dto.request;

import lombok.Builder;

@Builder
public record TextUpdateRequest(
        String xPosition,
        String yPosition,
        String content
) {}
