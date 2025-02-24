package com.server.moabook.user.service;

import com.server.moabook.global.exception.message.ErrorMessage;
import com.server.moabook.group.repository.GroupRepository;
import com.server.moabook.oauth2.entity.SocialUserEntity;
import com.server.moabook.oauth2.repository.UserRepository;
import com.server.moabook.user.dto.response.SelectUserResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public SelectUserResponseDto select(Long userId) {
        SocialUserEntity socialUserEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        return new SelectUserResponseDto(socialUserEntity.getUsername(), socialUserEntity.getProfile_image_url());
    }

    public void delete(Long userId) {
        SocialUserEntity socialUserEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        userRepository.delete(socialUserEntity);
    }

    public void deleteAll(Long userId) {
        SocialUserEntity socialUserEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        groupRepository.deleteAll(socialUserEntity.getGroups());
    }

}
