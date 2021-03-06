package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.model.Task;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.repository.TaskRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Task getElement(Long id) {
        return taskRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getElements() {
        return taskRepository.findAll();
    }

    @Override
    public void add(Task element) {
        taskRepository.save(element);
    }

    @Override
    public void update(Task element) {
        taskRepository.save(element);
    }

    @Override
    public void delete(Task element) {
        taskRepository.delete(element);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.delete(id);
    }

    @Override
    public Task save(Task element) {
        return taskRepository.save(element);
    }

    @Override
    
    public Task getByUserDataIdAndQuestionnaireId(Long userDataId, Long questionnaireId) {
        return taskRepository.findByUserDataIdAndQuestionnaireId(userDataId, questionnaireId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getByStatus(TaskType taskType) {
        return taskRepository.findByStatus(taskType);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getNumberTaskByQuestionnaire(Questionnaire q) {
        return taskRepository.getNumberTaskByQuestionnaire(q);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getNumberFinishTaskByQuestionnaire(Questionnaire q) {
        return taskRepository.getNumberFinishTaskByQuestionnaire(q);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getByStatusAndUserdata(TaskType status, UserData userData) {
        return taskRepository.findByStatusAndUserData(status, userData);
    }
    
}
