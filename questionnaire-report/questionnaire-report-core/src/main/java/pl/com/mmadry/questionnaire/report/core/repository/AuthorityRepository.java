package pl.com.mmadry.questionnaire.report.core.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.mmadry.questionnaire.report.core.enums.Role;
import pl.com.mmadry.questionnaire.report.core.model.Authority;
import pl.com.mmadry.questionnaire.report.core.model.AuthorityId;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

    List<Authority> findByUserName(String userName);
    Authority findByUserNameAndAuthority(String userName, Role role);

}
