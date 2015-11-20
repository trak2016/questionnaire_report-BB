package pl.com.mmadry.questionnaire.report.core.service;

import java.util.Date;
import java.util.List;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionnaireType;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface QuestionnaireService extends CrudService<Questionnaire, Long>{
    
    List<Questionnaire> getByStatus(QuestionnaireType ststus);
    
    List<Questionnaire> getByStatusAndDateEndBefore(QuestionnaireType ststus, Date endTime);
    
    List<Questionnaire> getByStatusAndDateEndAfter(QuestionnaireType ststus, Date endTime);
    
}
