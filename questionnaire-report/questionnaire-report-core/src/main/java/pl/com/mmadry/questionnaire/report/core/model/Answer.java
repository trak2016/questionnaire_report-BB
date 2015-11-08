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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@Table(name = "answer", schema = "public")
public class Answer extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "answer_userdata",
            joinColumns = {
                @JoinColumn(name = "answer_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "user_data_id", nullable = false, updatable = false)
            }
    )
    private List<UserData> userDatas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "number")
    private Integer number;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<UserData> getUserDatas() {
        return userDatas;
    }

    public void setUserDatas(List<UserData> userDatas) {
        this.userDatas = userDatas;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}
