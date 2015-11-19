package pl.com.mmadry.questionnaire.report.core.service;

import pl.com.mmadry.questionnaire.report.core.model.Task;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface TaskService extends CrudService<Task, Long>{
    
    Task getByUserDataIdAndQuestionnaireId(Long userDataId, Long questionnaireId);
    
}
