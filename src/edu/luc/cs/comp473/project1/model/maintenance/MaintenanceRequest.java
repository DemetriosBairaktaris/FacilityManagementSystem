package edu.luc.cs.comp473.project1.model.maintenance;

/**
 * This class creates MaintenanceRequest objects.
 * @author TeamDK
 *
 */
public class MaintenanceRequest {
    private boolean status;
    private String problem;
    
    public MaintenanceRequest(String problem) {
        status = false;
        this.problem = problem;
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
     * @return problem
     */
   public String getProblem(){
       return this.problem ; 
   }

}
