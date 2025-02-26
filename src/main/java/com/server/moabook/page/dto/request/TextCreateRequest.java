package com.server.moabook.page.dto.request;

import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.ElementType;
import com.server.moabook.page.domain.Page;
import lombok.Builder;

@Builder
public record TextCreateRequest(
        String xPosition,
        String yPosition,
        String content
) {
    public Element toEntity(Page page) {
        return Element.builder()
                .elementType(ElementType.TEXT)
                .xPosition(xPosition)
                .yPosition(yPosition)
                .content(content)
                .page(page)
                .build();
    }
}
