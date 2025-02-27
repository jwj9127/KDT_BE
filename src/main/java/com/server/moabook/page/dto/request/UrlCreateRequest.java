package com.server.moabook.page.dto.request;

import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.ElementType;
import com.server.moabook.page.domain.Page;
import lombok.Builder;

@Builder
public record UrlCreateRequest(
        String link
) {
    public Element toEntity(Page page, String ogTitle, String ogImage) {
        return Element.builder()
                .elementType(ElementType.URL)
                .link(link)
                .title(ogTitle)
                .thumbnailUrl(ogImage)
                .page(page)
                .build();
    }
}
