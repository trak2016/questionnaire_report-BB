package pl.com.mmadry.questionnaire.report.core.service;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.io.File;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Class MailServiceImpl
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class MailServiceImpl implements MailService {

    private static final Logger logger = Logger.getLogger(MailServiceImpl.class);

    private String defaultMailFrom;
    private String defaultReplyTo;
    private JavaMailSender mailSender;
    private MailTemplateService mailTemplateService;

    @Override
    public void sendMail(String mailTo, String subject, String messageText) {

        sendMail(new String[]{mailTo}, null, null, subject, messageText, null);
    }

    @Override
    public void sendMail(final String mailTo, final String subject, final String messageText,
            final Map<String, File> attachments) {

        sendMail(new String[]{mailTo}, null, null, subject, messageText, attachments);
    }

    @Override
    public void sendMail(final String[] mailTo, final String subject, final String messageText,
            final Map<String, File> attachments) {

        sendMail(mailTo, null, null, subject, messageText, attachments);
    }

    @Override
    public void sendMail(final String[] mailTo, final String[] mailCc, final String[] mailBcc,
            final String subject, final String messageText,
            final Map<String, File> attachments) {

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) {

                try {
                    MimeMessageHelper message = initMessage(mimeMessage, mailTo, mailCc, mailBcc);

                    message.setSubject(subject);
                    message.setText(messageText, true);

                    if (attachments != null) {
                        for (Map.Entry entry : attachments.entrySet()) {
                            message.addAttachment(entry.getKey().toString(),
                                    (File) entry.getValue());
                        }
                    }

                } catch (MessagingException ex) {
                    logger.warn("mail not send", ex);
                    throw new RuntimeException("mail not send", ex);
                }
            }
        };
        mailSender.send(mimeMessagePreparator);
        logger.info("email sent");
    }

    @Override
    public void sendMail(final String mailTo, final String subject, final String template,
            final Map<String, Object> params, final Map<String, File> attachments) {

        sendMail(mailTo, subject, mailTemplateService.mergeTemplate(template, params), attachments);
    }

    @Override
    public void sendMail(final String[] mailTo, final String subject, final String template,
            final Map<String, Object> params, final Map<String, File> attachments) {

        sendMail(mailTo, null, null, subject, mailTemplateService.mergeTemplate(template, params),
                attachments);
    }

    @Override
    public void sendMail(final String[] mailTo, final String[] mailCc, final String[] mailBcc,
            final String subject, final String template,
            final Map<String, Object> params, final Map<String, File> attachments) {

        sendMail(mailTo, mailCc, mailBcc, subject,
                mailTemplateService.mergeTemplate(template, params), attachments);
    }

    protected MimeMessageHelper initMessage(MimeMessage mimeMessage, String[] mailTo,
            String[] mailCc, String[] mailBcc)
            throws MessagingException {

        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setFrom(defaultMailFrom);
        message.setTo(mailTo);

        if (mailCc != null && mailCc.length != 0) {
            message.setCc(mailCc);
        }

        if (mailBcc != null && mailBcc.length != 0) {
            message.setBcc(mailBcc);
        }

        if (defaultReplyTo != null) {
            message.setReplyTo(defaultReplyTo);
        }

        return message;
    }

    public void setDefaultMailFrom(String defaultMailFrom) {

        this.defaultMailFrom = defaultMailFrom;
    }

    public void setDefaultReplyTo(String defaultReplyTo) {

        this.defaultReplyTo = defaultReplyTo;
    }

    public void setMailSender(JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    public void setMailTemplateService(MailTemplateService mailTemplateService) {

        this.mailTemplateService = mailTemplateService;
    }
}
