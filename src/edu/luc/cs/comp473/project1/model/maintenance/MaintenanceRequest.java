package edu.luc.cs.comp473.project1.model.maintenance;

/**
 * This class creates MaintenanceRequest objects.
 * @author TeamDK
 *
 */
public class MaintenanceRequest {
    private int status;
    private int id;
    private String problem;
    private static int seed_id = 0 ; 
    
    public MaintenanceRequest(String problem) {
        status = 0;
        id = seed_id++;
        this.problem = problem ; 
    }
    
    /**
     * This method returns the status
     * @return status
     */
    public int getStatus() {
        return this.status;
    }
    
    /**
     * This method sets the status
     * @param status
     */
    public void setStatus(int status) {
        this.status = status ; 
    }
    
    /**
     * This method returns the unique ID.
     * @return id
     */
    public int getID() {
        return id;
    }
    
    /**
     * This method returns the problem description.
     * @return problem
     */
   public String getProblem(){
       return this.problem ; 
   }

}



