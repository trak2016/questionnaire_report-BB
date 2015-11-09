package pl.com.mmadry.questionnaire.report.web.helper.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionType;
import pl.com.mmadry.questionnaire.report.core.model.Answer;
import pl.com.mmadry.questionnaire.report.core.model.Question;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.service.AnswerService;
import pl.com.mmadry.questionnaire.report.core.service.QuestionService;
import pl.com.mmadry.questionnaire.report.core.service.QuestionnaireService;
import pl.com.mmadry.questionnaire.report.web.assembler.QuestionnaireAssembler;
import pl.com.mmadry.questionnaire.report.web.assembler.parameters.QuestionnaireAssemblerParameters;
import pl.com.mmadry.questionnaire.report.web.dto.AnswerDTO;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionDTO;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionnaireDTO;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class QuestionnaireHelper extends BaseHelper {

    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private QuestionnaireAssembler questionnaireAssembler;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    public List<QuestionnaireDTO> getAll() {
        List<QuestionnaireDTO> questionnaireDTOs = new ArrayList<>();
        List<Questionnaire> questionnaires = questionnaireService.getElements();

        for (Questionnaire questionnaire : questionnaires) {
            QuestionnaireAssemblerParameters parameters = new QuestionnaireAssemblerParameters.Builder()
                    .dbo(questionnaire)
                    .build();
            questionnaireDTOs.add(questionnaireAssembler.assemblyToDto(parameters));
        }
        return questionnaireDTOs;
    }

    public void addNewQuestionnaire(QuestionnaireDTO dto) {

        if (dto == null) {
            return;
        }

        Questionnaire questionnaire;

        if (dto.getId() == null) {
            questionnaire = new Questionnaire();
        } else {
            questionnaire = questionnaireService.getElement(dto.getId());
        }

        questionnaire.setTitle(dto.getTitle());
        questionnaire.setTarger(dto.getTarger());
        questionnaire.setDescription(dto.getDescription());

        questionnaireService.add(questionnaire);

        List<Question> questions = new ArrayList<>();
        Integer i = 1;
        for (QuestionDTO questionDTO : dto.getQuestions()) {
            Question question;
            if (questionDTO.getId() == null) {
                question = new Question();
            } else {
                question = questionService.getElement(questionDTO.getId());
            }

            question.setNumber(i);
            question.setText(questionDTO.getText());
            question.setType(questionDTO.getType());
            question.setQuestionnaire(questionnaire);

            Integer j = 1;
            List<Answer> answers = new LinkedList<>();
            for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
                Answer answer;
                if (answerDTO.getId() == null) {
                    answer = new Answer();
                } else {
                    answer = answerService.getElement(answerDTO.getId());
                }
                answer.setNumber(j);
                answer.setText(answerDTO.getText());
                answer.setQuestion(question);
                answers.add(answer);
            }

            question.setAnswers(answers);

            i++;
            questionService.add(question);
            questions.add(question);
        }
        questionnaire.setQuestions(questions);
        questionnaireService.add(questionnaire);

    }

    private QuestionType getType(String type) {
        switch (type) {
            case "text":
                return QuestionType.TEXT;
            case "checkbox":
                return QuestionType.CHECK;
            case "radio":
                return QuestionType.RADIO;
        }

        return QuestionType.TEXT;
    }

    public QuestionnaireDTO getById(Long id) {
        QuestionnaireDTO dto = new QuestionnaireDTO();
        Questionnaire questionnaire = questionnaireService.getElement(id);

        dto.setId(questionnaire.getId());
        dto.setDescription(questionnaire.getDescription());
        dto.setTarger(questionnaire.getTarger());
        dto.setTitle(questionnaire.getTitle());

        List<QuestionDTO> questionsDTO = new LinkedList<>();
        for (Question question : questionnaire.getQuestions()) {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setNumber(question.getNumber());
            questionDTO.setType(question.getType());
            questionDTO.setText(question.getText());

            List<AnswerDTO> answersDTO = new LinkedList<>();
            if (!question.getType().equals("text")) {
                for (Answer answer : question.getAnswers()) {
                    AnswerDTO answerDTO = new AnswerDTO();
                    answerDTO.setId(answer.getId());
                    answerDTO.setNumber(answer.getNumber());
                    answerDTO.setText(answer.getText());
                    answersDTO.add(answerDTO);
                }
            }
            questionDTO.setAnswers(answersDTO);
            questionsDTO.add(questionDTO);
        }
        
        dto.setQuestions(questionsDTO);
        return dto;
    }

}
