package pl.com.mmadry.questionnaire.report.core.service;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Class MailTemplateServiceImpl
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
public class MailTemplateServiceImpl implements MailTemplateService {

    private VelocityEngine velocityEngine;
    private String appName;
    private String serverUrl;
    private String supportEmailAddress;

    @Override
    public String mergeTemplate(String templateName, Map<String, Object> map) {

        if (map == null) {
            map = new HashMap<>();
        }

        map.put("serverUrl", serverUrl);
        map.put("supportEmailAddress", supportEmailAddress);
        map.put("appName", appName);

        return VelocityEngineUtils
                .mergeTemplateIntoString(velocityEngine, "template/mail/" + templateName + ".html",
                                         "UTF8", map);
    }

    public VelocityEngine getVelocityEngine() {

        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {

        this.velocityEngine = velocityEngine;
    }

    public void setAppName(String appName) {

        this.appName = appName;
    }

    public void setServerUrl(String serverUrl) {

        this.serverUrl = serverUrl;
    }

    public void setSupportEmailAddress(String supportEmailAddress) {

        this.supportEmailAddress = supportEmailAddress;
    }
}
