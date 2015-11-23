package pl.com.mmadry.questionnaire.report.web.config;

import java.io.IOException;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import pl.com.mmadry.questionnaire.report.web.service.TestJob;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Configuration
public class QuartzConfig {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        
    }

    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();
        quartzScheduler.setSchedulerName("quartz-scheduler");

        // custom job factory of spring with DI support for @Autowired!
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        quartzScheduler.setJobFactory(jobFactory);

        Trigger[] triggers = {procesoMQTrigger().getObject()};
        quartzScheduler.setTriggers(triggers);

        return quartzScheduler;
    }

    @Bean
    public JobDetailFactoryBean procesoMQJob() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(TestJob.class);
        jobDetailFactory.setGroup("spring3-quartz");
        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean procesoMQTrigger() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(procesoMQJob().getObject());
        cronTriggerFactoryBean.setCronExpression("0 0/1 * * * ?");
        cronTriggerFactoryBean.setGroup("spring3-quartz");
        return cronTriggerFactoryBean;
    }

}
