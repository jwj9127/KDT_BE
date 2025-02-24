package com.server.moabook.oauth2.repository;

import com.server.moabook.oauth2.entity.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<SocialUserEntity, Long> {
    SocialUserEntity findByUsername(String username);
    Optional<SocialUserEntity> findByEmail(String email);

    @Query("SELECT u.email FROM SocialUserEntity u WHERE u.updated_at < :minusOneMonthAgoDateTime")
    List<String> findAllByExpiredUsersEmail(LocalDateTime minusOneMonthAgoDateTime);
}
