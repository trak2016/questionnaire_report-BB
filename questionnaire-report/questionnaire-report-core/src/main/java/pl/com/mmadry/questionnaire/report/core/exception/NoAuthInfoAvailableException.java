package pl.com.mmadry.questionnaire.report.core.exception;

/**
 * 
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class NoAuthInfoAvailableException extends RuntimeException {

    public NoAuthInfoAvailableException() {

    }

    public NoAuthInfoAvailableException(String message) {

        super(message);
    }

    public NoAuthInfoAvailableException(String message, Throwable cause) {

        super(message, cause);
    }

    public NoAuthInfoAvailableException(Throwable cause) {

        super(cause);
    }

    public NoAuthInfoAvailableException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }
}
