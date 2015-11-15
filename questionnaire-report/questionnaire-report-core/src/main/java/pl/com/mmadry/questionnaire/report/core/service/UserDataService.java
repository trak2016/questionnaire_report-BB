package pl.com.mmadry.questionnaire.report.core.service;

import pl.com.mmadry.questionnaire.report.core.enums.Role;
import pl.com.mmadry.questionnaire.report.core.model.UserData;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface UserDataService extends CrudService<UserData, Long> {

    void add(UserData element, Role... roles);

    void enableUser(long id);

    UserData findByToken(String token);
    
    UserData findByEmail(String email);
    
    String getLoggedUserLogin();

    UserData getLoggedUserData();
    
    UserData findByUsername(String username);

}
