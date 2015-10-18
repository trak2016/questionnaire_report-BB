package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.Answer;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface AnswerRepository extends JpaRepository<Answer, Long>{
    
}
