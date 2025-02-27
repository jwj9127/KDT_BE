package com.server.moabook.page.service;

import com.server.moabook.page.dto.request.UrlCreateRequest;
import com.server.moabook.page.dto.response.UrlResponse;

public interface UrlService {

    UrlResponse createUrlElement(Long userId, Long pageId, UrlCreateRequest request);
}
