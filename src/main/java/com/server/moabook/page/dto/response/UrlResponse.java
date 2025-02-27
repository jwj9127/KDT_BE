package com.server.moabook.page.dto.response;

import com.server.moabook.page.domain.Element;
import lombok.Builder;

@Builder
public record UrlResponse(
        Long elementId,
        String link,
        String title,
        String thumbnailUrl
) {
    public static UrlResponse from(Element element) {
        return UrlResponse.builder()
                .elementId(element.getElementId())
                .link(element.getLink())
                .title(element.getTitle())
                .thumbnailUrl(element.getThumbnailUrl())
                .build();
    }
}
