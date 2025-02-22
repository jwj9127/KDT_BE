package com.server.moabook.global.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    SIGNIN_SUCCESS(HttpStatus.CREATED.value(),"로그인에 성공하였습니다."),
    CREATE_GROUP_SUCCESS(HttpStatus.OK.value(),"그룹 생성을 성공하였습니다."),
    SELECT_GROUP_SUCCESS(HttpStatus.OK.value(),"그룹 조회를 성공하였습니다."),
    UPDATE_GROUP_SUCCESS(HttpStatus.OK.value(),"그룹 수정을 성공하였습니다."),
    DELETE_GROUP_SUCCESS(HttpStatus.OK.value(),"그룹 삭제를 성공하였습니다."),
    CREATE_BOOK_SUCCESS(HttpStatus.OK.value(),"책 생성을 성공하였습니다."),
    SELECT_BOOK_SUCCESS(HttpStatus.OK.value(),"책 조회를 성공하였습니다."),
    UPDATE_BOOK_SUCCESS(HttpStatus.OK.value(),"책 수정을 성공하였습니다."),
    DELETE_BOOK_SUCCESS(HttpStatus.OK.value(),"책 삭제를 성공하였습니다.");

    private final int code;
    private final String message;
}