package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.Task;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    Task findByUserDataIdAndQuestionnaireId(Long userDataId, Long questionnaireId);
    
}
