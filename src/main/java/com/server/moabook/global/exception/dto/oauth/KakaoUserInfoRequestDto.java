package com.server.moabook.global.exception.dto.oauth;

import lombok.Builder;

@Builder
public record KakaoUserInfoRequestDto(
        Long id,
        String name,
        String email,
        String profile_image_url
) {
}
