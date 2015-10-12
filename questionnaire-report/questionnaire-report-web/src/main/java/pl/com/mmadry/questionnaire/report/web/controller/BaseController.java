package pl.com.mmadry.questionnaire.report.web.controller;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Locale;

/**
 * 
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class BaseController {

    protected Logger logger = Logger.getLogger(getClass());

    public static String getBaseUrl() {
        return getBaseUrl("/");
    }

    public static String getBaseUrl(String path) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(path).build()
                .toUriString();
    }

    protected void logCalledMethod() {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("%s.%s()", this.getClass().getSimpleName(),
                                       Thread.currentThread().getStackTrace()[3].getMethodName()));
        }
    }

    protected void success(Model model, String code) {
        model.addAttribute("message", code);
    }

    protected void success(Model model) {
        model.addAttribute("message", "action_done");
    }

    protected void error(Model model, String code) {
        model.addAttribute("error", code);
    }

    protected void error(Model model) {
        model.addAttribute("error", "action_fail");
    }

    protected void success(RedirectAttributes redirectAttributes, String code) {
        redirectAttributes.addFlashAttribute("message", code);
    }

    protected void success(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "action_done");
    }

    protected void error(RedirectAttributes redirectAttributes, String code) {
        redirectAttributes.addFlashAttribute("error", code);
    }

    protected void error(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "action_fail");
    }

    protected String translate(String message, MessageSource messageSource, Locale locale) {
        return messageSource.getMessage(message, null, locale);
    }

    protected String translate(String message, MessageSource messageSource) {
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }
}
