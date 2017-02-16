
package edu.luc.cs.comp473.project1.model.facility;
import java.util.Date;

import edu.luc.cs.comp473.project1.model.System.ConcreteSystemLog;
import edu.luc.cs.comp473.project1.model.System.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class Inspection {
    private Date dateOfInspection ; 
    private boolean passed ;
    private SystemLog s ;
    /**
     * 
     * @param d
     */
    public Inspection(Date d){
        dateOfInspection = d ; 
        s = new ConcreteSystemLog();
        s.logCreate(this);
    }
    
    /**
     * 
     * @return Date
     */
    public Date getDate(){
        return dateOfInspection ; 
    }
    
    /**
     * 
     * @return boolean
     */
    public boolean getPassed(){
        return this.passed ; 
    }
    
    /**
     * 
     * @param v
     * @return void
     */
    public void setPassed(boolean v){
        this.passed = v; 
    }
    
    public String toString(){
        return "Inspection Date:  "+ this.getDate() + "\nPassed:  "+ this.getPassed();
    }
}
