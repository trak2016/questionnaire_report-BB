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
    private Integer number;
    private List<AnswerDTO> answers = new LinkedList<>();
    private String ansText;
    private Long ans;

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

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAnsText() {
        return ansText;
    }

    public void setAnsText(String ansText) {
        this.ansText = ansText;
    }

    public Long getAns() {
        return ans;
    }

    public void setAns(Long ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" + "id=" + id + ", text=" + text + ", type=" + type + ", number=" + number + ", answers=" + answers + ", ansText=" + ansText + ", ans=" + ans + '}';
    }

}
