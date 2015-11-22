package pl.com.mmadry.questionnaire.report.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class QuestionnaireDTO implements Serializable {

    private Long id;
    private String title;
    private String status;
    private String targer;
    private String description;
    private List<QuestionDTO> questions = new LinkedList<>();
    private Boolean correct;
    private Integer indexCal;
    private Date timeEnd;
    private List<UserdataDTO> users = new ArrayList<>();
    private Integer numberTask;
    private Integer numberFinishTask;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTarger() {
        return targer;
    }

    public void setTarger(String targer) {
        this.targer = targer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Integer getIndexCal() {
        return indexCal;
    }

    public void setIndexCal(Integer indexCal) {
        this.indexCal = indexCal;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public List<UserdataDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserdataDTO> users) {
        this.users = users;
    }

    public Integer getNumberTask() {
        return numberTask;
    }

    public void setNumberTask(Integer numberTask) {
        this.numberTask = numberTask;
    }

    public Integer getNumberFinishTask() {
        return numberFinishTask;
    }

    public void setNumberFinishTask(Integer numberFinishTask) {
        this.numberFinishTask = numberFinishTask;
    }
}
