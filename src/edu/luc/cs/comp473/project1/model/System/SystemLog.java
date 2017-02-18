package edu.luc.cs.comp473.project1.model.System;

import java.util.Date;

public abstract class SystemLog {
    
   public void logCreate(Object s){
       System.out.println("Creating "+s.getClass().getSimpleName()+":\n"+s.toString());
       System.out.println();
   }
   
   public void logVacate(Object s){
       System.out.println("Vacating "+s.getClass().getSimpleName()+":\n"+s.toString());
       System.out.println();
   }
   
   public void logInspect(Object s){
       System.out.println("Inspecting "+s.getClass().getSimpleName()+":\n"+s.toString());
       System.out.println();
   }
   
   public void logAdd(Object s,Object r){
       System.out.println("Adding "+s.getClass().getSimpleName()+":\n"+s.toString());
       System.out.println("To "+r.getClass().getSimpleName()+":\n"+r.toString());
       System.out.println();
   }
   
   public void logClose(Object s) {
       System.out.println("Closing " + s.getClass().getSimpleName() + ":\n" + s.toString() + "\n");
   }
   
   public void logSchedule(Date start, Date end) {
       System.out.println("Maintenance Scheduled for " + start.toString() + " to " + end.toString());
   }
}
