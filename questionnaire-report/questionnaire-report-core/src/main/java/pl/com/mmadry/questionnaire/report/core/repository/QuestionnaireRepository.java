package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.Questionnaire;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long>{
    
}
