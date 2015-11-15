package pl.com.mmadry.questionnaire.report.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.service.UserDataService;

/**
 * 
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class CacheServiceImpl implements CacheService, Serializable {

    transient private final Logger logger = Logger.getLogger(getClass());

    private UserData cachedUserData;

    private String appName;

    private String serverUrl;

    private String supportEmailAddress;

    @Autowired
    private UserDataService userDataService;

    @PostConstruct
    public void init() {
        logger.debug("Init CacheServiceImpl ...");
    }

    @Override
    public String getLoggedUserLogin() {
        return userDataService.getLoggedUserLogin();
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    @Override
    public void refreshCachedUser() {
        cachedUserData = userDataService.getLoggedUserData();
    }

    @Override
    public UserData getLoggedUserData() {
        if (cachedUserData == null) {
            cachedUserData = userDataService.getLoggedUserData();
        }
        return cachedUserData;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getSupportEmailAddress() {
        return supportEmailAddress;
    }

    public void setSupportEmailAddress(String supportEmailAddress) {
        this.supportEmailAddress = supportEmailAddress;
    }
}
