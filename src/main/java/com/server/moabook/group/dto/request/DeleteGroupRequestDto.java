package com.server.moabook.group.dto.request;

import jakarta.validation.constraints.NotNull;

public record DeleteGroupRequestDto (
        @NotNull(message = "그룹의 아이디는 비어있을 수 없습니다.")
        Long groupId
){
}
