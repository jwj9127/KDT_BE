package com.server.moabook.group.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateGroupRequestDto(
        @NotNull(message = "그룹의 이름이 비어있을 수 없습니다.")
        String name,

        @NotNull(message = "색상이 비어있을 수 없습니다.")
        String color
) {
}
