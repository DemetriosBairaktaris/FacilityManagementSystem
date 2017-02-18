package edu.luc.cs.comp473.project1.model.maintenance;

import edu.luc.cs.comp473.project1.model.System.SystemLog;

/**
 * This class creates MaintenanceRequest objects.
 * @author TeamDK
 *
 */
public class MaintenanceRequest {
    private boolean status;
    private String problem;
    private int num;
    private int openOrders;
    private SystemLog sysLog;
    
    public MaintenanceRequest(String problem, int num, SystemLog sysLog) {
        status = false;
        this.problem = problem;
        this.num = num;
        openOrders = 0;
        this.sysLog = sysLog;
        sysLog.logCreate(this);
    }
    
    /**
     * 
     * @return status
     */
    public boolean getStatus() {
        return status;
    }
    
    /**
     * 
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status ; 
    }

    /**
     * This method returns the problem description.
     * @return problem description
     */
   public String getProblem(){
       return this.problem ; 
   }
   
   public int getRequestNum() {
       return num;
   }
   
   public int getOpenOrders() {
       return openOrders;
   }
   
   public void addOpenOrder() {
       openOrders++;
   }
   
   public void removeOpenOrder() {
       openOrders--;
   }

   @Override
   public String toString() {
       return "Maintenance Request: " + this.getRequestNum() + "\nFor: " + this.getProblem() + "\nStatus: " + this.getStatus(); 
   }
}
