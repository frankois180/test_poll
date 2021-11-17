package com.testsurvey.domain.exception;

import lombok.Getter;

public class PollException extends  RuntimeException{
    @Getter
    private final NotificationCode notificationCode;

    public PollException(String message, NotificationCode notificationCode) {
        super(message);
        this.notificationCode = notificationCode;

    }
}
