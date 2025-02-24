package com.server.moabook.group.dto.response;

import com.server.moabook.group.dto.GroupDto;

import java.util.List;

public record SelectGroupResponseDto(
        List<GroupDto> groups
) {
}
