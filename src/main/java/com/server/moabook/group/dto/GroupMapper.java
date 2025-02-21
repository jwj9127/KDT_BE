package com.server.moabook.group.dto;

import com.server.moabook.group.domain.Group;
import com.server.moabook.group.dto.request.CreateGroupRequestDto;
import com.server.moabook.group.dto.response.SelectGroupResponseDto;
import com.server.moabook.oauth2.entity.SocialUserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class GroupMapper {

    public static Group toEntity(CreateGroupRequestDto createGroupRequestDto, SocialUserEntity user){
        return Group.builder()
            .name(createGroupRequestDto.name())
            .user(user)
            .build();
    }

    public static SelectGroupResponseDto toDTO(List<Group> groups) {
        List<GroupDto> groupDtos = groups.stream()
                .map(group -> new GroupDto(group.getGroupId(), group.getName()))
                .collect(Collectors.toList());
        return new SelectGroupResponseDto(groupDtos);
    }

}
