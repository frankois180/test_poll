package com.testsurvey.domain.service;

import com.testsurvey.domain.model.Poll;
import com.testsurvey.domain.port.PollRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepositoryPort pollRepositoryPort;

    public Poll save (Poll poll){
       return pollRepositoryPort.save(poll);
    }

    public  Poll findByCode(String  code){
        return pollRepositoryPort.findByCode(code);
    }

}
