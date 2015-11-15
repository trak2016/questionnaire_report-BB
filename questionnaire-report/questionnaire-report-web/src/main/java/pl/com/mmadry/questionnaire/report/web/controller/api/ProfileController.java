package pl.com.mmadry.questionnaire.report.web.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.com.mmadry.questionnaire.report.web.dto.ProfilDTO;
import pl.com.mmadry.questionnaire.report.web.helper.api.ProfilHelper;


/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@RestController
@RequestMapping(ProfileController.URL)
public class ProfileController {

    private final Logger log = LoggerFactory.getLogger(ProfileController.class);
    public static final String URL = "/api/profil";
    public static final String GET_CURRENT_USER_DATA = "/current";
    public static final String CHANGE_DATA = "/change";

    @Autowired
    private ProfilHelper profilHelper;

    @RequestMapping(value = ProfileController.GET_CURRENT_USER_DATA, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfilDTO> getCurrentUserData() {

        try {   
            return new ResponseEntity<>(profilHelper.getCurrentProfilData(), HttpStatus.OK);
        } catch (AccessDeniedException de) {     
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } catch (Exception e) {           
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = ProfileController.CHANGE_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfilDTO> changeData(@RequestBody ProfilDTO dto) {

        try {   
            return new ResponseEntity<>(profilHelper.changeProfilData(dto), HttpStatus.OK);
        } catch (AccessDeniedException de) {     
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } catch (Exception e) {           
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
       
}
