package pl.com.mmadry.questionnaire.report.core.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@Table(name = "task", schema = "public")
public class Task extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_data_id")
    private UserData userData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;

    @Enumerated(EnumType.STRING)
    private TaskType status;

    public TaskType getStatus() {
        return status;
    }

    public void setStatus(TaskType status) {
        this.status = status;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

}
