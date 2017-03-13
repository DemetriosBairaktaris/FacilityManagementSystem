package edu.luc.cs.fms.model.facility;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author TeamDK
 *
 */
public interface Use {

    public void setIntervals(List<ConcreteInterval> intervals);
    public List<ConcreteInterval> getIntervals();
    public void setList(List<ConcreteInterval> list);
    public List<ConcreteInterval> getList();
    public void setMinutesPerYear(float minutesPerYear);
    public float getMinutesPerYear();
    public void setNewIntervalAdded(boolean newIntervalAdded);
    public boolean getNewIntervalAdded();
    
  
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
}
