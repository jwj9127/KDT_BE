package com.server.moabook.oauth2.repository;

import com.server.moabook.oauth2.entity.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SocialUserEntity, Long> {
}
