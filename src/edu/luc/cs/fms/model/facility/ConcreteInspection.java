package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteInspection implements Inspection{

    private Date dateOfInspection;
    private boolean passed;
    private SystemLog sysLog;

    public ConcreteInspection(Date dateOfInspection, SystemLog sysLog) {
        this.dateOfInspection = dateOfInspection;
        this.sysLog = sysLog;
        //passed = false;
        sysLog.logCreate(this);
    }

    @Override
    public Date getDate() {
        return dateOfInspection;
    }

    @Override
    public boolean getPassed() {
        return this.passed;
    }

    @Override
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "Inspection Date:  " + this.getDate() + "\nPassed:  " + this.getPassed();
    }
}
