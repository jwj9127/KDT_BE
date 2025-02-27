package com.server.moabook.page.service;

import com.server.moabook.page.dto.request.TextCreateRequest;
import com.server.moabook.page.dto.request.TextUpdateRequest;
import com.server.moabook.page.dto.response.TextResponse;

import java.util.List;

public interface TextService {

    TextResponse createText(Long userId, Long pageId, TextCreateRequest request);

    TextResponse getText(Long userId, Long elementId);

    TextResponse updateText(Long userId, Long pageId, TextUpdateRequest request);

    void deleteText(Long userId, Long pageId);

    List<TextResponse> getAllTextsInPage(Long userId, Long pageId);
}
