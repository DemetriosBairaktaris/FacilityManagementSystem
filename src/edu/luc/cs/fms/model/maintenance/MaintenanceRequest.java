package edu.luc.cs.fms.model.maintenance;

public interface MaintenanceRequest {

    /**
     * @return status
     */
    public boolean getStatus();

    /**
     * sets the status of the request
     * @param status
     */
    public void setStatus(boolean status);

    /**
     * This method returns the problem description
     * @return problem description
     */
    public String getProblem();

    /**
     * 
     * @return request number
     */
    public int getRequestNum();

    /**
     * 
     * @return number of open orders
     */
    public int getOpenOrders();

    /**
     * adds an open order
     */
    public void addOpenOrder();

    /**
     * removes an order once closed
     */
    public void removeOpenOrder();
}
