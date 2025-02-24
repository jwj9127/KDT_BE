package com.server.moabook.security.service;

import com.server.moabook.global.exception.dto.oauth.KakaoUserInfoRequestDto;
import com.server.moabook.global.jwt.JwtTokenProvider;
import com.server.moabook.global.jwt.UserAuthentication;
import com.server.moabook.oauth2.entity.SocialUserEntity;
import com.server.moabook.oauth2.repository.UserRepository;
import com.server.moabook.security.dto.response.SuccessLoginResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class GeneralMemberService {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectUri;

    private static final String KAUTH_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private static final String KAPI_USER_URL = "https://kapi.kakao.com/v2/user/me";
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 사용자 정보 가져오기 - 이메일, 닉네임, 프로필 사진
    public SuccessLoginResponseDto findUserWithReact(KakaoUserInfoRequestDto userInfo) {

        SocialUserEntity socialUserEntity = userRepository.findById(userInfo.id())
                .orElseGet(() -> {
                    SocialUserEntity newGeneralMember = SocialUserEntity.builder()
                            .id(userInfo.id())
                            .username(userInfo.name())
                            .email(userInfo.email())
                            .role("ROLE_USER")
                            .profile_image_url(userInfo.profile_image_url())
                            .build();
                    return userRepository.save(newGeneralMember);
                });

        //로그인 시 사용자 사용시간 업데이트
        socialUserEntity.updateUserUpdateTime();
        //로그인 시 사용자가 나중에 다시 접속이 오래 이어지지 않았을 때 다시 이메일을 받을 수 있게 설정
        socialUserEntity.updateSendedEmailFalse();

        // JWT 토큰 발급
        String jwtToken = jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(socialUserEntity.getId())
        );

        return SuccessLoginResponseDto.builder()
                .id(socialUserEntity.getId())
                .name(socialUserEntity.getUsername())
                .email(socialUserEntity.getEmail())
                .profile_image_url(socialUserEntity.getProfile_image_url())
                .jwtToken(jwtToken)
                .build();
    }

}