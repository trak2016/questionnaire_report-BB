package pl.com.mmadry.questionnaire.report.core.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.enums.QuestionnaireType;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>{
    
    List<Questionnaire> findByStatus(QuestionnaireType status);
    
    List<Questionnaire> findByStatusAndTimeEndBefore(QuestionnaireType status, Date endTime);
    
    List<Questionnaire> findByStatusAndTimeEndAfter(QuestionnaireType status, Date endTime);
    
}
