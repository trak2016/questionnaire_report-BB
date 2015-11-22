package pl.com.mmadry.questionnaire.report.web.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.com.mmadry.questionnaire.report.web.helper.api.TaskHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@RestController
@RequestMapping(TaskController.URL)
public class TaskController {
    
    protected Logger logger = Logger.getLogger(getClass());
    public static final String URL = "/api/task";
    public static final String ALL_ACTIVE = "/allActive";
    public static final String ALL_FINISH = "/allFinish";
    
    @Autowired
    private TaskHelper taskHelper;
    
    @RequestMapping(value = TaskController.ALL_ACTIVE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActive() {
        return new ResponseEntity<>(taskHelper.getAllActive(), HttpStatus.OK);
    }
    
    @RequestMapping(value = TaskController.ALL_FINISH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFinish() {
        return new ResponseEntity<>(taskHelper.getAllFinish(), HttpStatus.OK);
    }
    
    
}
