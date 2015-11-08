package pl.com.mmadry.questionnaire.report.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionType;


/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@Table(name = "question", schema = "public")
public class Question extends BaseEntity{
    
    @Column()
    @Enumerated(EnumType.STRING)
    private QuestionType type;
    
    @Column(name = "text")
    private String text;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
    
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "question" , orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();
    
    @Column(name = "number")
    private Integer number;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers.clear();
        this.answers.addAll(answers);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    
}
