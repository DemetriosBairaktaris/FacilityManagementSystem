
package edu.luc.cs.fms.model.facility;

import java.util.Date;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteInterval implements Interval {

    private Date startDate;
    private Date endDate;
    private SystemLog sysLog;

    public ConcreteInterval() {/*default*/}
    
    
    @Override
    public void setSysLog(SystemLog sysLog){
        this.sysLog = sysLog ;
    }
    
    @Override
    public void log(){
        sysLog.logCreate(this);
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
    
    @Override
    public void setStartDate(Date startDate){
        this.startDate = startDate ; 
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
    public int compareTo(Interval interval) {
        return this.startDate.compareTo(interval.getStartDate());
    }

    @Override
    public String toString() {
        return startDate.toString() + " - " + endDate.toString();
    }
}
