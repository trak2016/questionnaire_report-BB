package pl.com.mmadry.questionnaire.report.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class QuestionReaportDTO {
    
    private String text;
    private String type;
    private List<AnswerReaportDTO> answers = new ArrayList<>();

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

    public List<AnswerReaportDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerReaportDTO> answers) {
        this.answers = answers;
    }
    
}
