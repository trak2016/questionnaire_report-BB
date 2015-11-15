package pl.com.mmadry.questionnaire.report.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.com.mmadry.questionnaire.report.core.model.UserData;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface UserDataRepository extends JpaRepository<UserData, Long>{
    
    UserData findByRegistrationToken(String token);
    UserData findByEmail(String email);
    @Query("select u from UserData u where u.user.username = ?1")
    UserData findByUsername(String username);
}
