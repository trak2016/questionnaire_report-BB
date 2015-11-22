package pl.com.mmadry.questionnaire.report.core.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.model.Task;
import pl.com.mmadry.questionnaire.report.core.model.UserData;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    Task findByUserDataIdAndQuestionnaireId(Long userDataId, Long questionnaireId);
    
    List<Task> findByStatus(TaskType status);
    
    @Query("select count(t.id) from Task t where t.questionnaire = :questionnaire")
    Integer getNumberTaskByQuestionnaire(@Param("questionnaire") Questionnaire q);
    
    @Query("select count(t.id) from Task t where t.questionnaire = :questionnaire and t.status = 'DONE'")
    Integer getNumberFinishTaskByQuestionnaire(@Param("questionnaire") Questionnaire q);
    
    List<Task> findByStatusAndUserData(TaskType status, UserData userData);
    
}
