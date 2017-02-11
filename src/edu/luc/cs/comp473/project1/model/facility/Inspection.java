package edu.luc.cs.comp473.project1.model.facility;

import java.util.Date;

public class Inspection {
    private Date dateOfInspection ; 
    private boolean passed ;
    
    public Inspection(Date d){
        dateOfInspection = d ; 
    }
    
    public Date getDate(){
        return dateOfInspection ; 
    }
    
    public boolean getPassed(){
        return this.passed ; 
    }
    public void setPassed(boolean v){
        this.passed = v; 
    }

}
