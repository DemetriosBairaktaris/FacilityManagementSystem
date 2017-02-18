package edu.luc.cs.comp473.project1.model.maintenance;

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
    
    public MaintenanceRequest(String problem, int num) {
        status = false;
        this.problem = problem;
        this.num = num;
        openOrders = 0;
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
       return "Maintenance Request: " + this.getRequestNum() + "\nfor: " + this.getProblem() + "\nStatus: " + this.getStatus(); 
   }
}
