package edu.luc.cs.comp473.project1.model.facility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Use {
    private List<Date> startDates ;
    private List<Date> endDates ; 
    private Date currentDate ; 
    
    public Use(){
        startDates = new ArrayList<>();
        endDates = new ArrayList<>();
        
    }
    
    public String listActualUsage(){
        if (startDates == null){
            return "No Usage" ; 
        }
        String usageDates = "Usage Dates:\n"; 
        for(int i = 0 ; i < startDates.size(); i++){
            usageDates= usageDates.concat(startDates.get(i).toString()+" - "+ endDates.get(i).toString()+"\n");
        }
        return usageDates ; 
    }
    
    public boolean assignFacilityToUse(Date one, Date two){
        currentDate = new Date();
        if(one.getTime()<currentDate.getTime())
        {
           return false ; 
        }
        else if(one.getTime() >= two.getTime()){
            return false ; 
        }
        else {
            startDates.add(one);
            endDates.add(two);
            return true ;
        }
    }
    
    

}
