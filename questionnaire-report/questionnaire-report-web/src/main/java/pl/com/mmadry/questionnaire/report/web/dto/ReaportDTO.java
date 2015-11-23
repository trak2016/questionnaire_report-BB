package pl.com.mmadry.questionnaire.report.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class ReaportDTO {
    
    private String questionnaireTitle;
    private String questionnaireTarger;
    private String questionnaireDescription;
    private List<QuestionReaportDTO> questions = new ArrayList<>();

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public String getQuestionnaireTarger() {
        return questionnaireTarger;
    }

    public void setQuestionnaireTarger(String questionnaireTarger) {
        this.questionnaireTarger = questionnaireTarger;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public void setQuestionnaireDescription(String questionnaireDescription) {
        this.questionnaireDescription = questionnaireDescription;
    }

    public List<QuestionReaportDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionReaportDTO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ReaportDTO{" + "questionnaireTitle=" + questionnaireTitle + ", questionnaireTarger=" + questionnaireTarger + ", questionnaireDescription=" + questionnaireDescription + ", questions=" + questions + '}';
    }

}
