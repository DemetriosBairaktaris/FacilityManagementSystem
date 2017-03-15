package edu.luc.cs.fms.model.facility;

import java.util.Date;
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

    public ConcreteInspection() {/*default*/}
    
    @Override
    public void setDateOfInspection(Date dateOfInspection){
        this.dateOfInspection = dateOfInspection ; 
    }
    
    @Override
    public void setSysLog(SystemLog sysLog){
        this.sysLog = sysLog ; 
    }
    
    @Override
    public void log(){
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
