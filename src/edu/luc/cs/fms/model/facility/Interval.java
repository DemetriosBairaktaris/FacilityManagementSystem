package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.system.SystemLog;

public interface Interval extends Comparable<Interval>{

    /**
     * 
     * @return starting date
     */
    public Date getStartDate();

    /**
     * 
     * @return end date
     */
    public Date getEndDate();
    
    /**
     * changes the end date if necessary
     * @param endDate
     * @return void
     */
    public void setEndDate(Date endDate);

    /**
     * 
     * @param startDate
     */
    void setStartDate(Date startDate);
    
    /**
     * used to log creation of the implementing object
     */
    void log();
    
    /**
     * 
     * @param sysLog
     */
    void setSysLog(SystemLog sysLog);
}
