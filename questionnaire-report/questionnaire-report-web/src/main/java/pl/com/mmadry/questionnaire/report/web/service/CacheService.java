package pl.com.mmadry.questionnaire.report.web.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.com.mmadry.questionnaire.report.core.model.UserData;

/**
 * 
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface CacheService {

    String getLoggedUserLogin();

    UserData getLoggedUserData();

    void logout(HttpServletRequest request, HttpServletResponse response);

    void refreshCachedUser();
}
