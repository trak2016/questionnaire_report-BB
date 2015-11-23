package pl.com.mmadry.questionnaire.report.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import pl.com.mmadry.questionnaire.report.web.config.QuartzConfig;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@WebListener
public class QuartzCheckQuestionnaire extends QuartzInitializerListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        QuartzConfig conf = new QuartzConfig();
        
        try {
            Scheduler scheduler = conf.quartzScheduler().getObject();
            scheduler.start();
        } catch (Exception e) {
            
        }
    }
    
}
