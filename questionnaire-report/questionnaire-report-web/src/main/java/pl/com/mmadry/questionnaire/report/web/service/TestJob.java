package pl.com.mmadry.questionnaire.report.web.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionnaireType;
import pl.com.mmadry.questionnaire.report.core.enums.TaskType;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;
import pl.com.mmadry.questionnaire.report.core.model.Task;
import pl.com.mmadry.questionnaire.report.core.repository.QuestionnaireRepository;
import pl.com.mmadry.questionnaire.report.core.repository.TaskRepository;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Service
@Transactional
public class TestJob implements Job {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void execute(final JobExecutionContext ctx)
            throws JobExecutionException {

        List<Questionnaire> questionnaires = questionnaireRepository.findByStatusAndTimeEndBefore(QuestionnaireType.ACTIVE, new Date());
        for (Questionnaire questionnaire : questionnaires) {
            questionnaire.setStatus(QuestionnaireType.FINISH);
            questionnaireRepository.save(questionnaire);
            List<Task> tasks = taskRepository.findByStatusAndQuestionnaire(TaskType.ACTIVE, questionnaire);
            for (Task task : tasks) {
                task.setStatus(TaskType.DONE_NOT);
                taskRepository.save(task);
            }
        }
    }

}
