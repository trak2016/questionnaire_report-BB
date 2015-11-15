package pl.com.mmadry.questionnaire.report.web.controller.api;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.com.mmadry.questionnaire.report.core.exception.NoAuthInfoAvailableException;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.service.UserDataService;
import pl.com.mmadry.questionnaire.report.web.dto.LoggedUserDTO;
import pl.com.mmadry.questionnaire.report.web.service.CacheService;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@RestController
@RequestMapping(AuthResource.URL)
public class AuthResource {

    protected Logger logger = Logger.getLogger(getClass());
    public static final String URL = "/api/auth";
    public static final String GET_LOGGED = "/logged";
    public static final String GET_LOGGED_OR_EMPTY = "/user";

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = AuthResource.GET_LOGGED, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoggedUserDTO> logged() {

        LoggedUserDTO loggedUserDTO = null;
        UserData userData = cacheService.getLoggedUserData();
        if (userData != null) {

            loggedUserDTO = new LoggedUserDTO(userData.getId(), userData.getName(), userData.getSurname(), userData.getEmail());
            for (GrantedAuthority ga : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
                loggedUserDTO.getRoleSet().add(ga.getAuthority());
            }
            
            return new ResponseEntity(loggedUserDTO, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = AuthResource.GET_LOGGED_OR_EMPTY, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoggedUserDTO> getLoggedOrEmptyUser() {

        LoggedUserDTO loggedUserDTO = null;
        try {
            UserData userData = cacheService.getLoggedUserData();
            if (userData != null) {
                loggedUserDTO = new LoggedUserDTO(userData.getId(), userData.getName(), userData.getSurname(), userData.getEmail());
            }
        } catch (NoAuthInfoAvailableException noAuthEx) {
            loggedUserDTO = new LoggedUserDTO(null, null, null, null);
        };

        return new ResponseEntity(loggedUserDTO, HttpStatus.OK);
    }

}
