package edu.luc.cs.comp473.project1.model.facility;

import java.util.Date;

public class Interval implements Comparable<Interval>{
    private Date startDate ;
    private Date endDate ; 
    
    
    public Interval(Date one, Date two){
        startDate = one ;
        endDate = two ;
    }
    
    public Date getStartDate(){
        return startDate ; 
    }
    public Date getEndDate(){
        return endDate ; 
    }

    @Override
    public int compareTo(Interval o) {
        return this.startDate.compareTo(o.getStartDate());
    }
    
    @Override
    public String toString(){
        return startDate.toString()+" - "+endDate.toString() ; 
    }

    public void setEndDate(Date endDate) {
       this.endDate = endDate;
        
    }
}
