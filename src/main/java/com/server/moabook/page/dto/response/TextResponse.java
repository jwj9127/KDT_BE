package com.server.moabook.page.dto.response;

import com.server.moabook.page.domain.Element;
import lombok.Builder;

@Builder
public record TextResponse(
        Long elementId,
        String xPosition,
        String yPosition,
        String content
) {
    public static TextResponse from(Element element) {
        return TextResponse.builder()
                .elementId(element.getElementId())
                .xPosition(element.getXPosition())
                .yPosition(element.getYPosition())
                .content(element.getContent())
                .build();
    }
}
