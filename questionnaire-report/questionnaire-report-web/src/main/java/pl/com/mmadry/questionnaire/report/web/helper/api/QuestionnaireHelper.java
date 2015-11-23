package pl.com.mmadry.questionnaire.report.web.helper.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionType;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionnaireType;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Answer;
import pl.com.mmadry.questionnaire.report.core.model.Question;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.model.Task;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.service.AnswerService;
import pl.com.mmadry.questionnaire.report.core.service.QuestionService;
import pl.com.mmadry.questionnaire.report.core.service.QuestionnaireService;
import pl.com.mmadry.questionnaire.report.core.service.TaskService;
import pl.com.mmadry.questionnaire.report.core.service.UserDataService;
import pl.com.mmadry.questionnaire.report.web.assembler.QuestionnaireAssembler;
import pl.com.mmadry.questionnaire.report.web.assembler.parameters.QuestionnaireAssemblerParameters;
import pl.com.mmadry.questionnaire.report.web.dto.AnswerDTO;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionDTO;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionnaireDTO;
import pl.com.mmadry.questionnaire.report.web.dto.UserdataDTO;
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
    @Autowired
    private IndexHelper indexHelper;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private TaskService taskService;

    public List<QuestionnaireDTO> getTemplates() {

        List<Questionnaire> questionnaires = questionnaireService.getByStatus(QuestionnaireType.TEMPLATE);
        return prepareDTOs(questionnaires, false);
    }

    public List<QuestionnaireDTO> getReadys() {
        List<Questionnaire> questionnaires = questionnaireService.getByStatusAndDateEndAfter(QuestionnaireType.ACTIVE, new Date());
        return prepareDTOs(questionnaires, true);
    }

    public List<QuestionnaireDTO> getFinish() {
        List<Questionnaire> questionnaires = questionnaireService.getByStatusAndDateEndBefore(QuestionnaireType.ACTIVE, new Date());
        return prepareDTOs(questionnaires, true);
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

        //date end
        Calendar c = Calendar.getInstance();
        c.setTime(dto.getTimeEnd());
        c.add(Calendar.DATE, 1);
        c.add(Calendar.HOUR, -1);
        c.add(Calendar.SECOND, -1);
        questionnaire.setTimeEnd(c.getTime());

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

            if (!question.getType().equals("text")) {
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
                    j++;
                }
            }

            question.setAnswers(answers);

            i++;
            questionService.add(question);
            questions.add(question);
        }
        questionnaire.setQuestions(questions);

        List<Task> tasks = new ArrayList<>();
        for (UserdataDTO udDTO : dto.getUsers()) {
            if (dto.getId() == null) {
                Task task = new Task();
                task.setQuestionnaire(questionnaire);
                task.setUserData(userDataService.getElement(udDTO.getId()));
                task.setStatus(TaskType.WAIT);
                tasks.add(task);
            } else {
                Task task = taskService.getByUserDataIdAndQuestionnaireId(udDTO.getId(), questionnaire.getId());
                if (task == null) {
                    task = new Task();
                    task.setQuestionnaire(questionnaire);
                    task.setUserData(userDataService.getElement(udDTO.getId()));
                    task.setStatus(TaskType.WAIT);
                }
                tasks.add(task);
            }
        }
        questionnaire.setTasks(tasks);

        IndexHelper.IndexInfo info = indexHelper.calculateIndex(questionnaire);
        questionnaire.setCorrect(info.allTestOK);
        questionnaire.setIndexCal(info.index);

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
        dto.setCorrect(questionnaire.getCorrect());
        dto.setIndexCal(questionnaire.getIndexCal());
        dto.setTimeEnd(questionnaire.getTimeEnd());

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

        List<UserdataDTO> userdatasDTO = new ArrayList<>();
        for (Task task : questionnaire.getTasks()) {
            UserdataDTO udDTO = new UserdataDTO();
            udDTO.setEmail(task.getUserData().getEmail());
            udDTO.setId(task.getUserData().getId());
            udDTO.setName(task.getUserData().getName());
            udDTO.setSurname(task.getUserData().getSurname());
            userdatasDTO.add(udDTO);
        }
        dto.setUsers(userdatasDTO);

        dto.setQuestions(questionsDTO);
        return dto;
    }

    private List<QuestionnaireDTO> prepareDTOs(List<Questionnaire> dbos, Boolean taskInformation) {
        List<QuestionnaireDTO> questionnaireDTOs = new ArrayList<>();
        for (Questionnaire questionnaire : dbos) {
            QuestionnaireAssemblerParameters parameters = new QuestionnaireAssemblerParameters.Builder()
                    .dbo(questionnaire)
                    .build();
            QuestionnaireDTO dto = questionnaireAssembler.assemblyToDto(parameters);

            if (taskInformation) {
                dto.setNumberTask(taskService.getNumberTaskByQuestionnaire(questionnaire));
                dto.setNumberFinishTask(taskService.getNumberFinishTaskByQuestionnaire(questionnaire));
            }

            questionnaireDTOs.add(dto);
        }
        return questionnaireDTOs;
    }

    public void startById(Long id) {
        Questionnaire q = questionnaireService.getElement(id);

        for (Task task : q.getTasks()) {
            task.setStatus(TaskType.ACTIVE);
            taskService.update(task);
        }

        q.setStatus(QuestionnaireType.ACTIVE);
        questionnaireService.update(q);
    }

    public void deleteById(Long id) {
        Questionnaire q = questionnaireService.getElement(id);
        q.setRemoved(true);
        questionnaireService.update(q);
    }

    public void sendQuestionnaire(QuestionnaireDTO dto) {

        UserData ud = userDataService.getLoggedUserData();
        for (QuestionDTO q : dto.getQuestions()) {
            if (q.getType().equals("text")) {
                Answer ans = new Answer();
                ans.setQuestion(questionService.getElement(q.getId()));
                ans.setText(q.getAnsText());
                ans.getUserDatas().add(ud);
                answerService.add(ans);

            }
            if (q.getType().equals("checkbox")) {
                for (AnswerDTO a : q.getAnswers()) {
                    if (a.getAns()) {
                        Answer ans = answerService.getElement(a.getId());
                        ans.getUserDatas().add(ud);
                        answerService.update(ans);
                    }
                }
            }
            if (q.getType().equals("radio")) {
                Answer answer = answerService.getElement(q.getAns());
                answer.getUserDatas().add(ud);
                answerService.update(answer);
            }

        }
        
        Task task = taskService.getByUserDataIdAndQuestionnaireId(ud.getId(), dto.getId());
        task.setStatus(TaskType.DONE);
        task.setTimeEnd(new Date());
        taskService.update(task);
    }

}
