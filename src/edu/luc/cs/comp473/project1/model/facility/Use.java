package edu.luc.cs.comp473.project1.model.facility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Use {
 
    private List<Interval> intervals ;
    private List<Interval> list ; 
    private Date currentDate ; 
    private float minutesPerYear ;
    private boolean newIntervalAdded;
    
    public Use(){
        intervals = new ArrayList<>();
        minutesPerYear = 525600 ; 
        newIntervalAdded = false ;
    }
    
    public String listActualUsage(){
        if (intervals.size() == 0){
            return "No Usage" ; 
        }
        String usageDates = "Usage Dates:\n"; 
        for (Interval i : intervals){
            usageDates = usageDates.concat(i.getStartDate()+ " - "+ i.getEndDate()+"\n");
        }
        return usageDates ; 
    }
    
    public boolean assignFacilityToUse(Date one, Date two){
        currentDate = new Date();
        if(one.getTime()<currentDate.getTime()){
           return false ; 
        }
        else if(one.getTime() >= two.getTime()){
            return false ; 
        }
        else {
            intervals.add(new Interval(one,two));
            newIntervalAdded = true ; 
            return true ;
        }
    }
    
    public boolean isInUseDuringInterval(Date one, Date two){
       if (intervals.size() == 0){return false;}
       if(newIntervalAdded){
           sortAndCombine();
           newIntervalAdded = false ;
       }
       
       for(Interval i : list){
           if (one.getTime() >= i.getStartDate().getTime() && two.getTime() <= i.getEndDate().getTime()){
               return true ;
           }
       }
       return false ;
    }
    
    @SuppressWarnings("deprecation")
    public double calcUsageRate(){
        double totalMinutes = 0 ;
        if(newIntervalAdded){
            sortAndCombine();
            newIntervalAdded = false ;
        }
        System.out.println(list);
        for(Interval i : list){
            totalMinutes+= i.getEndDate().getTime() - i.getStartDate().getTime() ;
            totalMinutes = totalMinutes/1000; 
            totalMinutes = totalMinutes/60 ; 
        }
        System.out.println(totalMinutes);
        return totalMinutes/minutesPerYear;
        
    }
    
    
    
    private void sortAndCombine(){
        Collections.sort(intervals);
        list = new LinkedList<>();
        list.add(intervals.get(0));
        for (int i = 1 ; i < intervals.size() ; i++){
            if(intervals.get(i).getStartDate().getTime()==list.get(0).getStartDate().getTime()){
                if(intervals.get(i).getEndDate().getTime()>list.get(0).getEndDate().getTime()){
                    list.get(0).setEndDate(intervals.get(i).getEndDate());
                }
            }
            else if(intervals.get(i).getStartDate().getTime()<list.get(0).getStartDate().getTime()){
                list.add(0, intervals.get(i));
            }
        }
    }
}
