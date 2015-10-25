package pl.com.mmadry.questionnaire.report.core.service;

import java.io.File;
import java.util.Map;

/**
 * Interface MailService
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface MailService {

    void sendMail(final String mailTo, final String subject, final String messageText);

    void sendMail(final String mailTo, final String subject, final String messageText,
                  final Map<String, File> attachments);

    void sendMail(final String[] mailTo, final String subject, final String messageText,
                  final Map<String, File> attachments);

    void sendMail(final String[] mailTo, final String[] mailCc, final String[] mailBcc,
                  final String subject, final String messageText,
                  final Map<String, File> attachments);

    void sendMail(final String mailTo, final String subject, final String template,
                  final Map<String, Object> params, final Map<String, File> attachments);

    void sendMail(final String[] mailTo, final String subject, final String template,
                  final Map<String, Object> params, final Map<String, File> attachments);

    void sendMail(final String[] mailTo, final String[] mailCc, final String[] mailBcc,
                  final String subject, final String template, final Map<String, Object> params,
                  final Map<String, File> attachments);
}
