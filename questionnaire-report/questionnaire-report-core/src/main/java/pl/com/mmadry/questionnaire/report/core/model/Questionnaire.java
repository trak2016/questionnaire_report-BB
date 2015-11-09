package pl.com.mmadry.questionnaire.report.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@Table(name = "questionnaire", schema = "public")
public class Questionnaire extends BaseEntity{
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "status")
    private String status;
    
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
    
    @OneToMany(mappedBy = "questionnaire")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
    
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "term_id")
    private Term term;

    public Questionnaire() {
        this.status = "template";
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
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
     
}
