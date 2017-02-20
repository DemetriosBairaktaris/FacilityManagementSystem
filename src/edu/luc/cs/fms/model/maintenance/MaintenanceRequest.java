package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class creates MaintenanceRequest objects.
 * 
 * @author TeamDK
 *
 */
public class MaintenanceRequest {

    private boolean status;
    private String problem;
    private int num;
    private int openOrders;

    public MaintenanceRequest(String problem, int num, SystemLog sysLog) {
        status = false;
        this.problem = problem;
        this.num = num;
        openOrders = 0;
        sysLog.logCreate(this);
    }

    /**
     * @return status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * sets the status of the reqeust
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
        return num;
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
