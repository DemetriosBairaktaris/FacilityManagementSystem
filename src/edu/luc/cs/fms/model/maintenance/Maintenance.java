package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface Maintenance {

    /**
     * makes a maintenance request
     * @param problem
     */
    public void makeFacilityMaintRequest(String problem);

    /**
     * schedules maintenance for specified dates
     * @param start
     * @param end
     * @return true if successful
     */
    public boolean scheduleMaintenance(Date start, Date end);

    /**
     * calculates total maintenance cost
     * @return
     */
    public BigDecimal calcMaintenanceCostForFacility();

    /**
     * calculates problem rate per 365 days
     * @return
     */
    public float calcProblemRateForFacility();

    /**
     * calculates down time for facility
     * @return
     */
    public long calcDownTimeForFacility();

    /**
     * retrieves a list of maintenance requests
     * @return
     */
    public List<MaintenanceRequest> listMaintRequests();

    /**
     * retrieves list of maintenance performed
     * @return
     */
    public List<Order> listMaintenance();

    /**
     * lists the problems in the maintenance requests
     * @return
     */
    public String listFacilityProblems();

    /**
     * creates an order and assigns it to a maintenance request
     * @param desc
     * @param requestNum
     */
    public void createOrder(String desc, int requestNum);

    /**
     * sets labor cost for an order
     * @param cost
     * @param orderNum
     */
    public void setLaborCost(BigDecimal cost, int orderNum);

    /**
     * sets parts cost for an order
     * @param cost
     * @param orderNum
     */
    public void setPartsCost(BigDecimal cost, int orderNum);

    /**
     * closes maintenance request if it has no open orders
     * @param requestNum
     */
    public void closeRequest(int requestNum);

    /**
     * closes an order and removes it from maintenance request
     * @param orderNum
     * @param requestNum
     */
    public void closeOrder(int orderNum, int requestNum);

}
