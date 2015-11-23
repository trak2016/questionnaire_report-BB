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
import pl.com.mmadry.questionnaire.report.web.helper.api.ReaportHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@RestController
@RequestMapping(ReaportController.URL)
public class ReaportController {
    
    protected Logger logger = Logger.getLogger(getClass());
    public static final String URL = "/api/reaport";
    public static final String GENERAL = "/general/{id}";
    
    @Autowired
    private ReaportHelper reaportHelper;
    
    @RequestMapping(value = ReaportController.GENERAL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGeneralById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reaportHelper.generalReaport(id), HttpStatus.OK);
    }
    
}
