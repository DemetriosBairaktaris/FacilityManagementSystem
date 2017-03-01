
package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteInterval implements Interval, Comparable<ConcreteInterval> {

    private Date startDate;
    private Date endDate;
    private SystemLog s;

    public ConcreteInterval(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        s = new ConcreteSystemLog();
        s.logCreate(this);
    }

    /**
     * 
     * @return starting date
     */
    @Override
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 
     * @return end date
     */
    @Override
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * changes the end date if necessary
     * @param endDate
     * @return void
     */
    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int compareTo(ConcreteInterval interval) {
        return this.startDate.compareTo(interval.getStartDate());
    }

    @Override
    public String toString() {
        return startDate.toString() + " - " + endDate.toString();
    }
}
