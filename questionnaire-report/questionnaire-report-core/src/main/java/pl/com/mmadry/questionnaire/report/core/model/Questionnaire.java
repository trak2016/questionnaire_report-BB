package pl.com.mmadry.questionnaire.report.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionnaireType;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@Table(name = "questionnaire", schema = "public")
public class Questionnaire extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    private QuestionnaireType status;

    @Column(name = "target")
    private String targer;

    @Column(name = "description")
    private String description;

    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST})
    @OneToMany(mappedBy = "questionnaire", orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "questionnaire_userdata",
            joinColumns = {
                @JoinColumn(name = "questionnaire_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "user_data_id", nullable = false, updatable = false)
            }
    )
    private List<UserData> userDatas = new ArrayList<>();

    @OneToMany(mappedBy = "questionnaire", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timeEnd")
    private Date timeEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timeReminder")
    private Date timeReminder;

    @Column
    private Boolean correct;

    @Column(name = "index_cal")
    private Integer indexCal;

    public Questionnaire() {
        this.status = QuestionnaireType.TEMPLATE;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks.clear();
        this.tasks.addAll(tasks);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTarger() {
        return targer;
    }

    public void setTarger(String targer) {
        this.targer = targer;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions.clear();
        this.questions.addAll(questions);
    }

    public List<UserData> getUserDatas() {
        return userDatas;
    }

    public void setUserDatas(List<UserData> userDatas) {
        this.userDatas = userDatas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionnaireType getStatus() {
        return status;
    }

    public void setStatus(QuestionnaireType status) {
        this.status = status;
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

    public Date getTimeReminder() {
        return timeReminder;
    }

    public void setTimeReminder(Date timeReminder) {
        this.timeReminder = timeReminder;
    }
}
