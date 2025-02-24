package com.server.moabook.oauth2.entity;

import com.server.moabook.group.domain.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class SocialUserEntity {
    @Id
    @Column(name = "userId")
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    private String role;

    private String profile_image_url;

    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups;

    public void updateUserUpdateTime(){
        this.updated_at = LocalDateTime.now();
    }
}