package pl.com.mmadry.questionnaire.report.core.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Task;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    Task findByUserDataIdAndQuestionnaireId(Long userDataId, Long questionnaireId);
    
    List<Task> findByStatus(TaskType status);
    
}
