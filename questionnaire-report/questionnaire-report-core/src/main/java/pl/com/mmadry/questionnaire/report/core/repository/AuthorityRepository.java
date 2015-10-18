package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.Authority;
import pl.com.mmadry.questionnaire.report.core.model.AuthorityId;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId>{
    
}
