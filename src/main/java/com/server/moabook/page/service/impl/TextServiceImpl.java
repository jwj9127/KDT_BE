package com.server.moabook.page.service.impl;


import com.server.moabook.page.domain.Element;
import com.server.moabook.page.domain.ElementType;
import com.server.moabook.page.domain.Page;
import com.server.moabook.page.dto.request.TextCreateRequest;
import com.server.moabook.page.dto.request.TextUpdateRequest;
import com.server.moabook.page.dto.response.TextResponse;
import com.server.moabook.page.repository.ElementRepository;
import com.server.moabook.page.repository.PageRepository;
import com.server.moabook.page.service.TextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TextServiceImpl implements TextService {

    private final ElementRepository elementRepository;
    private final PageRepository pageRepository;


    @Override
    @Transactional
    public TextResponse createText(Long userId, Long pageId, TextCreateRequest request) {
        Page page = pageRepository.findById(pageId)
                .orElseThrow(() -> new RuntimeException("해당 페이지 없음"));

        Element element = request.toEntity(page);

        Element saved = elementRepository.save(element);
        return TextResponse.from(saved);
    }

    @Override
    @Transactional
    public TextResponse getText(Long userId, Long elementId) {
        Element element = elementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("TEXT 없음"));

        if (element.getElementType() != ElementType.TEXT) {
            throw new RuntimeException("요청하신 Element는 TEXT 타입이 아님");
        }

        return TextResponse.from(element);
    }

    @Override
    @Transactional
    public TextResponse updateText(Long userId, Long elementId, TextUpdateRequest request) {

        Element element = elementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("TEXT Element 없음"));


        if (element.getElementType() != ElementType.TEXT) {
            throw new RuntimeException("수정하려는 Element는 TEXT 타입이 아님");
        }

        element.updateContent(request.content());
        element.updatePosition(request.xPosition(), request.yPosition());

        return TextResponse.from(element);
    }

    @Override
    @Transactional
    public void deleteText(Long userId, Long elementId) {
        Element element = elementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("TEXT Element 없음"));


        if (element.getElementType() != ElementType.TEXT) {
            throw new RuntimeException("삭제하려는 Element는 TEXT 타입이 아님");
        }

        elementRepository.delete(element);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TextResponse> getAllTextsInPage(Long userId, Long pageId) {
        // 1. page 조회
        Page page = pageRepository.findById(pageId)
                .orElseThrow(() -> new RuntimeException("해당 페이지 없음"));

        // 2. TEXT 요소 목록 조회
        List<Element> textElements = elementRepository.findAllByPageAndElementType(page, ElementType.TEXT);

        // 3. Entity → DTO 변환
        return textElements.stream()
                .map(TextResponse::from)
                .toList();
    }
}
