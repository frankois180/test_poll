package com.testsurvey.domain.port;

import com.testsurvey.domain.model.Poll;

import java.util.Optional;

public interface PollRepositoryPort {
    Poll save (Poll poll);
    Poll findByCode(String code);
}
