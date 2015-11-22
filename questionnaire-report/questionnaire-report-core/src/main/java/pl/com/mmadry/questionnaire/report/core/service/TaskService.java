package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Task;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface TaskService extends CrudService<Task, Long>{
    
    Task getByUserDataIdAndQuestionnaireId(Long userDataId, Long questionnaireId);
    
    List<Task> getByStatus(TaskType taskType);
    
}
