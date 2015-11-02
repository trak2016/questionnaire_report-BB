package pl.com.mmadry.questionnaire.report.web.dto;

import java.io.Serializable;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class QuestionnaireDTO implements Serializable {

    private String title;
    private String status;
    private String targer;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTarger() {
        return targer;
    }

    public void setTarger(String targer) {
        this.targer = targer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" + "title=" + title + ", status=" + status + ", targer=" + targer + ", description=" + description + '}';
    }
    
}
