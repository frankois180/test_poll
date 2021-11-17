package com.testsurvey.domain.exception;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum NotificationCode {

    DATA_NOT_FOUND("data not found", "IN_ERR_NF");
    private String message;
    private String apiCode;
}
