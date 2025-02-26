package com.server.moabook.oauth2.repository;

import com.server.moabook.oauth2.entity.SocialUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<SocialUserEntity, Long> {
    SocialUserEntity findByUsername(String username);
    Optional<SocialUserEntity> findByEmail(String email);

    @Query("SELECT u.email FROM SocialUserEntity u WHERE u.updated_at < :minusOneMonthAgoDateTime AND u.received_email = true AND u.sended_email = false")
    List<String> findAllByExpiredUsersEmail(LocalDateTime minusOneMonthAgoDateTime);

    @Query("SELECT u FROM SocialUserEntity u WHERE u.id = :id")
    SocialUserEntity findByKakaoUserId(Long id);


    @Modifying
    @Query("UPDATE SocialUserEntity u SET u.sended_email = true WHERE u.email IN :emails")
    int updateSendedEmailByEmails(@Param("emails") List<String> emails);
}
