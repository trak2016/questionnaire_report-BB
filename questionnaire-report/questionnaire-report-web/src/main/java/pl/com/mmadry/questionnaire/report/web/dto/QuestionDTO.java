package pl.com.mmadry.questionnaire.report.web.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class QuestionDTO implements Serializable{
    
    private Long id;
    private String text;
    private String type;
    private Integer order;
    private List<AnswerDTO> answers = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" + "id=" + id + ", text=" + text + ", type=" + type + ", order=" + order + ", answers=" + answers + '}';
    }

}
