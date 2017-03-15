package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.system.SystemLog;

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
    
    /**
     * used to log the creation of the implementing object
     */
    void log();
    
    /**
     * 
     * @param sysLog
     */
    void setSysLog(SystemLog sysLog);
    
    /**
     * 
     * @param dateOfInspection
     */
    void setDateOfInspection(Date dateOfInspection);
}
