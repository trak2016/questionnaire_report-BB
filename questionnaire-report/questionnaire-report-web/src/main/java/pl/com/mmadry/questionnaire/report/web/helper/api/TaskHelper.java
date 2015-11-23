package pl.com.mmadry.questionnaire.report.web.helper.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Task;
import pl.com.mmadry.questionnaire.report.core.service.TaskService;
import pl.com.mmadry.questionnaire.report.core.service.UserDataService;
import pl.com.mmadry.questionnaire.report.web.dto.TaskDTO;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class TaskHelper extends BaseHelper{
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private UserDataService userDataService;
    
    public List<TaskDTO> getAllActive(){
        
        List<Task> tasks = taskService.getByStatus(TaskType.ACTIVE);
        return prepareTaskDTOs(tasks);
    
    }
    
    public List<TaskDTO> getAllFinish(){
        
        List<Task> tasks = taskService.getByStatus(TaskType.DONE);
        tasks.addAll(taskService.getByStatus(TaskType.DONE_NOT));
        return prepareTaskDTOs(tasks);

    }
    
    public List<TaskDTO> getAllUserActive(){
        
        List<Task> tasks = taskService.getByStatusAndUserdata(TaskType.ACTIVE, userDataService.getLoggedUserData());
        return prepareUserTaskDTOs(tasks);
    
    }
    
    public List<TaskDTO> getAllUserFinish(){
        
        List<Task> tasks = taskService.getByStatusAndUserdata(TaskType.DONE_NOT, userDataService.getLoggedUserData());
        tasks.addAll(taskService.getByStatusAndUserdata(TaskType.DONE, userDataService.getLoggedUserData()));
        return prepareUserTaskDTOs(tasks);

    }
    
    private List<TaskDTO> prepareTaskDTOs(List<Task> tasks){
        List<TaskDTO> taskDTOs = new ArrayList<>();
        
        for(Task task : tasks){
            TaskDTO dto = new TaskDTO();
            dto.setQuestionnaireId(task.getQuestionnaire().getId());
            dto.setQuestionnaireTitle(task.getQuestionnaire().getTitle());
            dto.setTimeEnd(task.getQuestionnaire().getTimeEnd());
            dto.setUserEmail(task.getUserData().getEmail());
            dto.setUserName(task.getUserData().getName());
            dto.setUserSurname(task.getUserData().getSurname());
            dto.setStatus(task.getStatus().name());
            taskDTOs.add(dto);
        }
        return taskDTOs;   
    }
    
    private List<TaskDTO> prepareUserTaskDTOs(List<Task> tasks){
        List<TaskDTO> taskDTOs = new ArrayList<>();
        
        for(Task task : tasks){
            TaskDTO dto = new TaskDTO();
            dto.setQuestionnaireId(task.getQuestionnaire().getId());
            dto.setQuestionnaireTitle(task.getQuestionnaire().getTitle());
            dto.setTimeEnd(task.getQuestionnaire().getTimeEnd());
            dto.setStatus(task.getStatus().name());
            taskDTOs.add(dto);
        }
        return taskDTOs;   
    }
    
}
