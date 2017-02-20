package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class Inspection {

    private Date dateOfInspection;
    private boolean passed;
    private SystemLog s;

    public Inspection(Date d) {
        dateOfInspection = d;
        passed = false;
        s = new ConcreteSystemLog();
        s.logCreate(this);
    }

    /**
     * 
     * @return Date of inspection
     */
    public Date getDate() {
        return dateOfInspection;
    }

    /**
     * 
     * @return true if passed
     */
    public boolean getPassed() {
        return this.passed;
    }

    /**
     * sets if the inspection passed
     * @param passed
     * @return void
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "Inspection Date:  " + this.getDate() + "\nPassed:  " + this.getPassed();
    }
}
