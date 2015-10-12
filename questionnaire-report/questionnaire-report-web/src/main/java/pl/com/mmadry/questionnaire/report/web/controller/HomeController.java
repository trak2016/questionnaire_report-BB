package pl.com.mmadry.questionnaire.report.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class HomeController
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Controller
public class HomeController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        logCalledMethod();

        return "redirect:/index.html";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        logCalledMethod();

        return "/index";
    }
}
