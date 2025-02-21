package com.server.moabook.security.dto.member.response;

import java.time.LocalDate;

public record BusinessMemberResponseDto(
        Long id,
        String businessName,
        Long businessNumber,
        String businessAddress,
        LocalDate businessStartDate,
        String businessPhoneNumber,
        String businessEmail
){
}