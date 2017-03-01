package edu.luc.cs.fms.model.facility;

import java.util.Date;

public interface Interval {

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
}
