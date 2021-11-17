package com.testsurvey.domain.service;

import com.testsurvey.domain.model.Poll;
import com.testsurvey.domain.model.Questions;
import com.testsurvey.domain.model.QuestionsDetail;
import com.testsurvey.domain.port.PollRepositoryPort;
import com.testsurvey.domain.types.QuestionType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class PollServiceTest {

    private PollService pollService;

    private  PollRepositoryPort pollRepositoryPort;
    private Poll poll;
    @BeforeEach
    public void init() {
        pollRepositoryPort = Mockito.mock(PollRepositoryPort.class);
        pollService = new PollService(pollRepositoryPort);
        poll = new Poll();
        poll.setCode("123");
        poll.setUsername("pacheco");

        Questions questions = new Questions();
        questions.setDescription("what up ");
        questions.setType(QuestionType.MULTIPLE);

        QuestionsDetail questionsDetail = new QuestionsDetail();
        questionsDetail.setDescription("test descripcion multiple");

        questions.setQuestionsDetails(Arrays.asList(questionsDetail));
        poll.setQuestions(Arrays.asList(questions));
    }

    @Test
    public  void when_savePoll_withType_Multiple_then_object_noyNull(){
        // arrange
        Mockito.when(pollRepositoryPort.save(Mockito.any())).thenReturn(poll);
        Poll pollResult = pollService.save(poll);
        // act - assert
        Assertions.assertThat(pollResult).isNotNull();
    }
}
