package pl.com.mmadry.questionnaire.report.web.controller.app.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import pl.com.mmadry.questionnaire.report.web.controller.BaseController;
import pl.com.mmadry.questionnaire.report.web.form.registration.RegistrationForm;
import pl.com.mmadry.questionnaire.report.web.helper.app.registration.RegistrationHelper;

/**
 * Class RegistrationController
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Controller
@RequestMapping("/app/registration")
public class RegistrationController extends BaseController {

    @Autowired
    private RegistrationHelper registrationHelper;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model) {

        logCalledMethod();

        registrationHelper.prepareForm(model);

        return "/app/registration/form";
    }

    @RequestMapping(value = "/formAction", method = RequestMethod.POST)
    public String formAction(
            @Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        logCalledMethod();

        registrationHelper.checkErrors(registrationForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/app/registration/form";
        }

        registrationHelper.registerUser(registrationForm);

        redirectAttributes.addFlashAttribute("message",
                                             "Użytkownik zarejestrowany poprawnie. Potwierdź konto.");

        return "redirect:/app/auth/login";
    }

    @RequestMapping(value = "/{token}/confirm", method = RequestMethod.GET)
    public String confirm(@PathVariable("token") String token,
                          RedirectAttributes redirectAttributes) {

        logCalledMethod();

        boolean confirmUser = registrationHelper.confirmUser(token);

        String message = "Użytkownik potwierdzony";
        if (!confirmUser) {
            message = "Błąd podczas potwierdzania użytkownika";
        }

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/app/auth/login";
    }
}
