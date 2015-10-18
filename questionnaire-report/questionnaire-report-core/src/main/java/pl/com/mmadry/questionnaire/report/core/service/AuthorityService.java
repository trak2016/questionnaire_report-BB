package pl.com.mmadry.questionnaire.report.core.service;

import java.util.List;
import pl.com.mmadry.questionnaire.report.core.enums.Role;
import pl.com.mmadry.questionnaire.report.core.model.Authority;
import pl.com.mmadry.questionnaire.report.core.model.AuthorityId;


/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface AuthorityService extends CrudService<Authority, AuthorityId> {

    List<Authority> findByUserName(String userName);
    Authority findByUserAndRole(String username, Role role);
}
