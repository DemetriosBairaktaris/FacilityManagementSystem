package edu.luc.cs.fms.model.facility;

import java.util.Date;

/**
 * 
 * @author TeamDK
 *
 */
public interface Use {

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
