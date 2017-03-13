package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class creates MaintenanceRequest objects.
 * 
 * @author TeamDK
 *
 */
public class ConcreteMaintenanceRequest implements MaintenanceRequest{

    private boolean status;
    private String problem;
    private int requestNum;
    private int openOrders;

    public ConcreteMaintenanceRequest(String problem, int requestNum, SystemLog sysLog) {
        //status = false;
        this.problem = problem;
        this.requestNum = requestNum;
        //openOrders = 0;
        sysLog.logCreate(this);
    }
    
    public void setOpenOrders(int openOrders) {
      this.openOrders = openOrders;
    }

    /**
     * @return status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * sets the status of the request
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * This method returns the problem description
     * @return problem description
     */
    public String getProblem() {
        return this.problem;
    }

    /**
     * 
     * @return request number
     */
    public int getRequestNum() {
        return requestNum;
    }

    /**
     * 
     * @return number of open orders
     */
    public int getOpenOrders() {
        return openOrders;
    }

    /**
     * adds an open order
     */
    public void addOpenOrder() {
        openOrders++;
    }

    /**
     * removes an order once closed
     */
    public void removeOpenOrder() {
        openOrders--;
    }

    @Override
    public String toString() {
        return "Maintenance Request #" + this.getRequestNum() + "\nStatus: " + this.getStatus() + "\nProblem: "
                + this.getProblem();
    }
}
