package pl.com.mmadry.questionnaire.report.web.dto;

import java.util.Date;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class TaskDTO {
    
    private Long questionnaireId;
    private String questionnaireTitle;
    private Date timeEnd;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String status;

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    
    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskDTO{" + "questionnaireId=" + questionnaireId + ", questionnaireTitle=" + questionnaireTitle + ", timeEnd=" + timeEnd + ", userName=" + userName + ", userSurname=" + userSurname + ", userEmail=" + userEmail + ", status=" + status + '}';
    }

}
