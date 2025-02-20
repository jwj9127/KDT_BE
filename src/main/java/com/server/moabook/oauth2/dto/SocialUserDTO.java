package com.server.moabook.oauth2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialUserDTO {
    private Long id;
    private String email;
    private String username;
    private String role;
    private String profile_image_url;
}