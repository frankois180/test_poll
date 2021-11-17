package com.testsurvey.infrastructure.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Getter
@Setter
public class PollDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String username;

    private String code;
    @NotEmpty
    private List<QuestionsDTO> questions;
}
