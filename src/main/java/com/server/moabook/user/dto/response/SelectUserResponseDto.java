package com.server.moabook.user.dto.response;

public record SelectUserResponseDto(
        String username,
        String profile_image_url
) {
}
