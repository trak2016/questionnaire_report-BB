package pl.com.mmadry.questionnaire.report.web.dto;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class AnswerReaportDTO {
    
    private String text;
    private Integer count;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AnswerReaportDTO{" + "text=" + text + ", count=" + count + '}';
    }
    
}
