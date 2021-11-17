package com.testsurvey.domain.model;
import com.testsurvey.domain.types.QuestionType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Questions {
    private Long id;
    private String description;
    private QuestionType type;
    private List<QuestionsDetail> questionsDetails;
}
