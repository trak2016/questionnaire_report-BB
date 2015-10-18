package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.Term;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface TermRepository extends JpaRepository<Term, Long>{
    
}
