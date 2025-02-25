package com.server.moabook.user.service;

import com.server.moabook.global.exception.message.ErrorMessage;
import com.server.moabook.group.repository.GroupRepository;
import com.server.moabook.oauth2.entity.SocialUserEntity;
import com.server.moabook.oauth2.repository.UserRepository;
import com.server.moabook.user.dto.response.SelectUserResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);


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

    public void updateReceivedEmail(Long userId, String email, boolean check) {
        SocialUserEntity socialUserEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.valueOf(ErrorMessage.USER_NOT_FOUND)));
        socialUserEntity.updateReceivedEmail(check);
        if(isValidEmail(email)) {
            socialUserEntity.updateEmail(email);
        }
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false; // null 또는 빈 값 체크
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

}
