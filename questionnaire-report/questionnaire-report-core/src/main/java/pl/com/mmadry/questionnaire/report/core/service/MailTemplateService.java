package pl.com.mmadry.questionnaire.report.core.service;

import java.util.Map;

/**
 * Interface MailTemplateService
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public interface MailTemplateService {

    String mergeTemplate(String templateName, Map<String, Object> map);
}
