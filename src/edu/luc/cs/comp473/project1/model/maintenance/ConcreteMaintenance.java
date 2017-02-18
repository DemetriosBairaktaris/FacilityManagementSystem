package edu.luc.cs.comp473.project1.model.maintenance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.luc.cs.comp473.project1.model.System.SystemLog;

/**
 * This class is the interface between the client and the domain model for the maintenance objects
 * @author TeamDK
 *
 */
public class ConcreteMaintenance implements Maintenance {

    private Log log;
    private List<MaintenanceRequest> requests;
    private List<Order> orders;
    private Schedule schedule;
    private BigDecimal cost;
    private int orderNum;
    private int requestNum;
    private int numRequests;
    private SystemLog sysLog;
    
    public ConcreteMaintenance(SystemLog sysLog) {
        log = new Log();
        requests = new ArrayList<MaintenanceRequest>();
        orders = new ArrayList<Order>();
        schedule = new Schedule();
        cost = new BigDecimal("0");
        orderNum = 0;
        requestNum = 0;
        this.sysLog = sysLog;
        sysLog.logCreate(this);
    }
    
    /**
     * Makes a maintenance request and creates an order
     * @param problem
     */
    public void makeFacilityMaintenanceRequest(String problem) {
        MaintenanceRequest request = new MaintenanceRequest(problem, requestNum, sysLog);
        requests.add(request);
        requestNum++;
    }
    
    /**
     * Schedules the maintenance to be performed in the schedule
     * @param date1
     * @param date2
     * @return true for successful, false for failure
     */
    public boolean scheduleMaintenance(Date date1, Date date2) {
        return schedule.scheduleMaintenance(date1, date2);
    }
    
    /**
     * 
     * @return total cost for facility
     */
    public BigDecimal calcMaintenanceCostForFacility() {
        for (int i = 0; i < orders.size(); i++) {
            cost = cost.add(orders.get(i).getCost());
        }
        return cost;
    }
    
    /**
     * creates an order for maintenance
     * @param desc
     */
    public void createOrder(String desc, int requestNum) {
        Order order = new Order(desc, orderNum, sysLog);
        orders.add(order);
        orderNum++;
        requests.get(requestNum).addOpenOrder();
    }
    
    /**
     * closes an order when finished
     * @param orderNum
     */
    public void closeOrder(int orderNum, int requestNum) {
        Order order = orders.get(orderNum);
        order.setStatus(true);
        sysLog.logClose(order);
        log.addOrder(order);
        requests.get(requestNum).removeOpenOrder();
    }
    
    public void closeRequest(int requestNum) {
        MaintenanceRequest request = requests.get(requestNum);
        if (request.getOpenOrders() == 0) {
            request.setStatus(true);
            sysLog.logClose(request);
        }
        else {
            return;
        }
    }
    
    /**
     * sets the cost of parts on an order
     * @param cost
     * @param orderNum
     */
    public void setPartsCost(BigDecimal cost, int orderNum) {
        Order order = orders.get(orderNum);
        order.setLaborCost(cost);
    }
    
    /**
     * sets the cost of labor on an order
     * @param cost
     * @param orderNum
     */
    public void setLaborCost(BigDecimal cost, int orderNum) {
        Order order = orders.get(orderNum);
        order.setPartsCost(cost);
    }
    
    /**
     * determines the problem rate for the facility
     * @return problems / year in days
     */
    public int calcProblemRateForFacility() {
        numRequests = requests.size();
        return numRequests / 365;
    }
    
    /**
     * 
     * @return total down time for the scheduled maintenance
     */
    public long calcDownTimeForFacility() {
        return schedule.calcDownTimeForFacility();
    }
    
    /**
     * 
     * @return all maintenance requests
     */
    public List<MaintenanceRequest> listMaintenanceRequests() {
        return requests;
    }
    
    /**
     * 
     * @return all maintenance added to the log
     */
    public List<Order> listMaintenance() {
        return log.getMaintenanceList();
    }
    
    /**
     * 
     * @return all problems from maintenance requests
     */
    public String listFacilityProblems() {
        
        String problems = "Facility Problems:\n";
        
        if (requests == null) {
            return "No facility problems.";
        }
        
        for (int i = 0; i < requests.size(); i++) {
            problems = problems.concat(requests.get(i).getProblem() + "\n");
        }
        
        return problems;
    }
}
