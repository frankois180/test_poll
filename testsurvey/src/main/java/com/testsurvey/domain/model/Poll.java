package com.testsurvey.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Poll {
    private String name;
    private String code;
    private String status;
    private String username;
    private LocalDateTime creationDate;
    private List<Questions> questions;
}
