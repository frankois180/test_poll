package com.testsurvey.infrastructure.controller.dto;

import com.testsurvey.domain.types.QuestionType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
public class QuestionsDTO {
    @NotBlank
    private String description;
    @NotNull
    private QuestionType type;
    private List<QuestionsDetailDTO> questionsDetails;
}
