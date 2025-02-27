package com.server.moabook.page.service.impl;

import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.Page;
import com.server.moabook.page.dto.request.UrlCreateRequest;
import com.server.moabook.page.dto.response.UrlResponse;
import com.server.moabook.page.repository.ElementRepository;
import com.server.moabook.page.repository.PageRepository;
import com.server.moabook.page.service.UrlService;
import com.server.moabook.page.url.OgMeta;
import com.server.moabook.page.url.OgParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlServiceImpl implements UrlService {

    private final PageRepository pageRepository;
    private final ElementRepository elementRepository;

    @Override
    @Transactional
    public UrlResponse createUrlElement(Long userId, Long pageId, UrlCreateRequest request) {
        Page page = pageRepository.findById(pageId)
                .orElseThrow(() -> new RuntimeException("페이지를 찾을 수 없음"));

        OgMeta ogMeta = OgParser.parse(request.link());

        Element element = request.toEntity(page, ogMeta.getTitle(), ogMeta.getImage());

        Element saved = elementRepository.save(element);

        return UrlResponse.from(saved);
    }

}
