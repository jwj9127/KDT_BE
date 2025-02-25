package com.server.moabook.mail;

import com.server.moabook.oauth2.entity.SocialUserEntity;
import com.server.moabook.oauth2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BatchService {

    private final UserRepository userRepository;
    private final MailService mailService;

    public void sendMail() {

        LocalDateTime oneMonthAgoDateTime = LocalDateTime.now().minusMonths(1);
        String[] userEmailList = userRepository.findAllByExpiredUsersEmail(oneMonthAgoDateTime).toArray(new String[0]);
        //이메일을 발송했다면 해당 사용자들의 sended_email을 true로 변경
        for (String email : userEmailList) {
            userRepository.findByEmail(email).ifPresent(SocialUserEntity::updateSendedEmailTrue);
        }
        mailService.sendSimpleMailMessage(userEmailList);
    }
}
