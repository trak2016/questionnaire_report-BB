package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.User;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface UserRepository extends JpaRepository<User, String>{
    
}
