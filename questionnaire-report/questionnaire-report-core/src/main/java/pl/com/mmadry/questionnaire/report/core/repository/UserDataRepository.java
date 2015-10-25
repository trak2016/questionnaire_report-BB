package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.model.UserData;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface UserDataRepository extends JpaRepository<UserData, Long>{
    
    UserData findByRegistrationToken(String token);
    UserData findByEmail(String email);
}
