package pl.com.mmadry.questionnaire.report.web.helper;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * Class BaseHelper
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class BaseHelper {

    protected final Logger logger = Logger.getLogger(getClass());

    protected String translate(String message, MessageSource messageSource, Locale locale) {
        return messageSource.getMessage(message, null, locale);
    }

    protected String translate(String message, MessageSource messageSource) {
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }

    protected void logCalledMethod() {

        if (logger.isDebugEnabled()) {
            logger.debug(String.format("%s.%s()", getClass().getSimpleName(),
                                       Thread.currentThread().getStackTrace()[3].getMethodName()));
        }
    }
}
