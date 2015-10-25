package pl.com.mmadry.questionnaire.report.web.controller.app.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.com.mmadry.questionnaire.report.web.controller.BaseController;

/**
 * Class AuthController
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Controller
@RequestMapping("/app/auth")
public class AuthController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        logCalledMethod();

        return "/app/auth/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {

        logCalledMethod();

        return "/app/auth/logout";
    }

}
