package pl.com.mmadry.questionnaire.report.web.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.com.mmadry.questionnaire.report.web.dto.QuestionnaireDTO;
import pl.com.mmadry.questionnaire.report.web.helper.api.QuestionnaireHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@RestController
@RequestMapping(QuestionnaireController.URL)
public class QuestionnaireController {
    
    protected Logger logger = Logger.getLogger(getClass());
    public static final String URL = "/api/questionnaire";
    public static final String ALL = "/all";
    public static final String ADD = "/add";
    public static final String GET_BY_ID = "/get/{id}";
    
    @Autowired
    private QuestionnaireHelper questionnaireHelper;
    
    @RequestMapping(value = QuestionnaireController.ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(questionnaireHelper.getAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value = QuestionnaireController.ADD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewQuestionnaire(@RequestBody QuestionnaireDTO dto) {
        questionnaireHelper.addNewQuestionnaire(dto);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    
    @RequestMapping(value = QuestionnaireController.GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(questionnaireHelper.getById(id), HttpStatus.OK);
    }
    
}
