
package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class Interval implements Comparable<Interval> {

    private Date startDate;
    private Date endDate;
    private SystemLog s;

    public Interval(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        s = new ConcreteSystemLog();
        s.logCreate(this);
    }

    /**
     * 
     * @return starting date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 
     * @return end date
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * changes the end date if necessary
     * @param endDate
     * @return void
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int compareTo(Interval interval) {
        return this.startDate.compareTo(interval.getStartDate());
    }

    @Override
    public String toString() {
        return startDate.toString() + " - " + endDate.toString();
    }
}
