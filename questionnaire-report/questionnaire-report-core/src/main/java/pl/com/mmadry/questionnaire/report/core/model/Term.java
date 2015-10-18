package pl.com.mmadry.questionnaire.report.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@Table(name = "term", schema = "public")
public class Term extends BaseEntity{

    @Temporal(TemporalType.DATE)
    @Column(name="timeEnd")
    private Date timeEnd;
    
    @Temporal(TemporalType.DATE)
    @Column(name="timeReminder")
    private Date timeReminder;
   

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Date getTimeReminder() {
        return timeReminder;
    }

    public void setTimeReminder(Date timeReminder) {
        this.timeReminder = timeReminder;
    }
    
    
  
}
