package com.testsurvey.infrastructure.adapter;

import com.testsurvey.domain.DataNotFoundException;
import com.testsurvey.domain.exception.NotificationCode;
import com.testsurvey.domain.model.Poll;
import com.testsurvey.domain.model.Questions;
import com.testsurvey.domain.model.QuestionsDetail;
import com.testsurvey.domain.port.PollRepositoryPort;
import com.testsurvey.infrastructure.adapter.repository.entity.PollJpaEntity;
import com.testsurvey.infrastructure.adapter.repository.entity.QuestionsDetailJpaEntity;
import com.testsurvey.infrastructure.adapter.repository.entity.QuestionsJpaEntity;
import com.testsurvey.infrastructure.adapter.repository.jpa.PollJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PollRepositoryAdapter implements PollRepositoryPort {
    private final PollJpaRepository pollJpaRepository;

    @Override
    public Poll save(Poll poll) {

        return fromJpa(pollJpaRepository.save(fromDomain(poll)));
    }

    @Override
    public Poll findByCode(String code) {
        return fromJpa(pollJpaRepository.findByCode(code).orElseThrow(()-> new DataNotFoundException(NotificationCode.DATA_NOT_FOUND)));
    }

    private PollJpaEntity fromDomain(Poll poll){
        PollJpaEntity pollJpaEntity = new PollJpaEntity();
        pollJpaEntity.setCode(UUID.randomUUID().toString());
        pollJpaEntity.setName(poll.getName());
        pollJpaEntity.setStatus(poll.getStatus());
        pollJpaEntity.setUsername(poll.getUsername());
        pollJpaEntity.setQuestions(poll.getQuestions().stream().map(this::fromDomainQuestions).collect(Collectors.toList()));

        return  pollJpaEntity;
    }
    private QuestionsJpaEntity fromDomainQuestions(Questions questions){
        QuestionsJpaEntity questionsJpaEntity = new QuestionsJpaEntity();
        questionsJpaEntity.setDescription(questions.getDescription());
        questionsJpaEntity.setType(questions.getType());
        questionsJpaEntity.setQuestionsDetails(questions.getQuestionsDetails().stream().map(this::fromDomainDetail).collect(Collectors.toList()));

        return  questionsJpaEntity;
    }

    private  QuestionsDetailJpaEntity fromDomainDetail(QuestionsDetail questionsDetail){
        QuestionsDetailJpaEntity questionsDetailJpaEntity = new QuestionsDetailJpaEntity();
        questionsDetailJpaEntity.setDescription(questionsDetail.getDescription());
        return questionsDetailJpaEntity;
    }

    private Poll fromJpa(PollJpaEntity pollJpaEntity){
        Poll poll = new Poll();
        poll.setCode(pollJpaEntity.getCode());
        poll.setCreationDate(pollJpaEntity.getCreationDate());
        poll.setName(pollJpaEntity.getName());
        poll.setStatus(pollJpaEntity.getStatus());
        poll.setCode(pollJpaEntity.getCode());
        poll.setUsername(pollJpaEntity.getUsername());
        poll.setQuestions(pollJpaEntity.getQuestions().stream().map(this::fromQuestionsJpa).collect(Collectors.toList()));
        return poll;
    }

    private Questions fromQuestionsJpa(QuestionsJpaEntity questionsJpaEntity){
        Questions questions = new Questions();
        questions.setDescription(questionsJpaEntity.getDescription());
        questions.setType(questionsJpaEntity.getType());
        questions.setQuestionsDetails(questionsJpaEntity.getQuestionsDetails().stream().map(this::fromDetailJpa).collect(Collectors.toList()));
        return  questions;
    }

    private QuestionsDetail fromDetailJpa(QuestionsDetailJpaEntity questionsDetailJpaEntity){
        QuestionsDetail questionsDetail = new QuestionsDetail();
        questionsDetail.setDescription(questionsDetailJpaEntity.getDescription());
        return  questionsDetail;
    }
}
