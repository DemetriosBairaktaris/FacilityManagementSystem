
package edu.luc.cs.comp473.project1.model.facility;

import java.util.Date;

/**
 * 
 * @author TeamDK
 *
 */
public class Interval implements Comparable<Interval>{
    private Date startDate ;
    private Date endDate ; 
    
    /**
     * 
     * @param one
     * @param two
     */
    public Interval(Date one, Date two){
        startDate = one ;
        endDate = two ;
    }
    
    /**
     * 
     * @return Date
     */
    public Date getStartDate(){
        return startDate ; 
    }
    
    /**
     * 
     * @return Date
     */
    public Date getEndDate(){
        return endDate ; 
    }
    
    /**
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Interval o) {
        return this.startDate.compareTo(o.getStartDate());
    }
    
    /**
     * @return String
     */
    @Override
    public String toString(){
        return startDate.toString()+" - "+endDate.toString() ; 
    }

    /**
     * 
     * @param endDate
     * @return void
     */
    public void setEndDate(Date endDate) {
       this.endDate = endDate;
    }
}
