
package edu.luc.cs.comp473.project1.model.facility;
import java.util.Date;
/**
 * 
 * @author TeamDK
 *
 */
public class Inspection {
    private Date dateOfInspection ; 
    private boolean passed ;
    
    /**
     * 
     * @param d
     */
    public Inspection(Date d){
        dateOfInspection = d ; 
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
}
