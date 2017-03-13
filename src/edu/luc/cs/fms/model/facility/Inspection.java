package edu.luc.cs.fms.model.facility;

import java.util.Date;

public interface Inspection {

  
    /**
     * @return Date of inspection
     */
    public Date getDate();

    /**
     * @return true if passed
     */
    public boolean getPassed();

    /**
     * sets if the inspection passed
     * @param passed
     * @return void
     */
    public void setPassed(boolean passed);
}
