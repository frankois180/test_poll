package com.testsurvey.application;

import com.testsurvey.domain.model.Poll;
import com.testsurvey.domain.model.Questions;
import com.testsurvey.domain.model.QuestionsDetail;
import com.testsurvey.domain.service.PollService;
import com.testsurvey.infrastructure.controller.dto.PollDTO;
import com.testsurvey.infrastructure.controller.dto.QuestionsDTO;
import com.testsurvey.infrastructure.controller.dto.QuestionsDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PollAppService {
    private final PollService pollService;

    public PollDTO save(PollDTO pollDTO) {
        return fromDomain(pollService.save(fromDto(pollDTO)));
    }

    public PollDTO findByCode(String code){
        return  fromDomain(pollService.findByCode(code));
    }

    private PollDTO fromDomain(Poll poll) {
        PollDTO pollDTO = new PollDTO();
        pollDTO.setName(poll.getName());
        pollDTO.setCode(poll.getCode());
        pollDTO.setUsername(poll.getUsername());
        pollDTO.setQuestions(poll.getQuestions().stream().map(this::fromQuestionDomain).collect(Collectors.toList()));
        return pollDTO;
    }

    private QuestionsDTO fromQuestionDomain(Questions questions) {
        QuestionsDTO questionsDTO = new QuestionsDTO();
        questionsDTO.setQuestionsDetails(questions.getQuestionsDetails().stream().map(this::fromDetailDomain).collect(Collectors.toList()));
        questionsDTO.setDescription(questions.getDescription());
        questionsDTO.setType(questions.getType());
        return questionsDTO;

    }

    private QuestionsDetailDTO fromDetailDomain(QuestionsDetail questionsDetail) {
        QuestionsDetailDTO questionsDetailDTO = new QuestionsDetailDTO();
        questionsDetailDTO.setDescription(questionsDetail.getDescription());
        return questionsDetailDTO;
    }

    private Poll fromDto(PollDTO pollDTO) {
        Poll poll = new Poll();
        poll.setName(pollDTO.getName());
        poll.setUsername(pollDTO.getUsername());
        poll.setQuestions(pollDTO.getQuestions().stream().map(this::fromQuestionDto).collect(Collectors.toList()));

        return poll;

    }

    private Questions fromQuestionDto(QuestionsDTO questionsDTO) {
        Questions questions = new Questions();
        questions.setQuestionsDetails(questionsDTO.getQuestionsDetails().stream().map(this::fromDetailDto).collect(Collectors.toList()));
        questions.setType(questionsDTO.getType());
        questions.setDescription(questionsDTO.getDescription());
        return questions;
    }

    private QuestionsDetail fromDetailDto(QuestionsDetailDTO questionsDetailDTO) {
        QuestionsDetail questionsDetail = new QuestionsDetail();
        questionsDetail.setDescription(questionsDetailDTO.getDescription());
        return questionsDetail;
    }

}
