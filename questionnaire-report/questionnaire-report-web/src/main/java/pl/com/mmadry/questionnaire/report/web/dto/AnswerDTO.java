package pl.com.mmadry.questionnaire.report.web.dto;

import java.io.Serializable;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class AnswerDTO implements Serializable{
    
    private Long id;
    private String text;
    private Integer order;

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" + "id=" + id + ", text=" + text + ", order=" + order + '}';
    }

}
