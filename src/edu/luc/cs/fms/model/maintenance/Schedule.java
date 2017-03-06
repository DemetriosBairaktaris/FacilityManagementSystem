package edu.luc.cs.fms.model.maintenance;

import java.util.Date;

public interface Schedule {
    /**
     * schedules the request's maintenance
     * @param start
     * @param end
     * @return true if successful, false if failure
     */
    public boolean scheduleMaintenance(Date start, Date end);

    /**
     * @return total down time for facility from total maintenance
     */
    public long calcDownTimeForFacility();
}
