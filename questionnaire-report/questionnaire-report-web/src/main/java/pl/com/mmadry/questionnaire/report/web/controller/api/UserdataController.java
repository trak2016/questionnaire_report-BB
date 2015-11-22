package pl.com.mmadry.questionnaire.report.web.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.com.mmadry.questionnaire.report.web.helper.api.UserdataHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@RestController
@RequestMapping(UserdataController.URL)
public class UserdataController {
    
    protected Logger logger = Logger.getLogger(getClass());
    public static final String URL = "/api/userdata";
    public static final String GET_ALL = "/all";
    public static final String BLOCH_UNLOCK_BY_ID = "/blockunlock/{id}";
    
    @Autowired
    private UserdataHelper userDataHelper;
    
    @RequestMapping(value = UserdataController.GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDataHelper.getAllUserData(), HttpStatus.OK);
    }
    
    @RequestMapping(value = UserdataController.BLOCH_UNLOCK_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> blockUnlockById(@PathVariable("id") Long id) {
        userDataHelper.blockUnlockUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
