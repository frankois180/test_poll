package com.testsurvey.domain;

import com.testsurvey.domain.exception.NotificationCode;
import com.testsurvey.domain.exception.PollException;

public class DataNotFoundException extends PollException {

    public DataNotFoundException(NotificationCode notificationCode) {
        super(notificationCode.getMessage(),notificationCode);
    }
}