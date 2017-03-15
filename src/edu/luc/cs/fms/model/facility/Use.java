package edu.luc.cs.fms.model.facility;

import java.util.Date;
import java.util.List;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public interface Use {

    public void setIntervals(List<Interval> intervals);
    public List<Interval> getIntervals();
    public void setList(List<Interval> list);
    public void setMinutesPerYear(float minutesPerYear);
    public float getMinutesPerYear();
   
    
    /**
     * @return list of actual usage
     */
    public String listActualUsage();

    /**
     * assigns a facility to use between specified dates
     * @param start
     * @param end
     * @return true if successful
     */
    public boolean assignFacilityToUse(Date start, Date end);

    /**
     * checks if facility is in use during specific interval
     * @param start
     * @param end
     * @return boolean
     */
    public boolean isInUseDuringInterval(Date start, Date end);

    /**
     * determines the total usage rate
     * @return double
     */
    public double calcUsageRate();
    
    /**
     * 
     * @param sysLog
     */
    void setSysLog(SystemLog sysLog);
    
    /**
     * used to log creation of implementing object
     */
    void log();
}
