package pl.com.mmadry.questionnaire.report.web.dto;

import java.io.Serializable;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class AnswerDTO implements Serializable{
    
    private Long id;
    private String text;
    private Integer number;
    private Boolean ans;

    public AnswerDTO() {
        this.ans = false;
    }

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getAns() {
        return ans;
    }

    public void setAns(Boolean ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" + "id=" + id + ", text=" + text + ", number=" + number + ", ans=" + ans + '}';
    }

}
