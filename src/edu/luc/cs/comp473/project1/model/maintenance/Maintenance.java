package edu.luc.cs.comp473.project1.model.maintenance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is the interface between the client and the domain model for the maintenance objects
 * @author TeamDK
 *
 */
public class Maintenance {

    private Log log;
    private List<MaintenanceRequest> requests;
    private List<Order> orders;
    private Schedule schedule;
    private BigDecimal cost;
    private int orderNum;
    private int numRequests;
    private List<Technician> technicians;
    
    public Maintenance() {
        log = new Log();
        requests = new ArrayList<MaintenanceRequest>();
        orders = new ArrayList<Order>();
        schedule = new Schedule();
        cost = new BigDecimal("0");
        orderNum = 0;
        technicians = new ArrayList<Technician>();
    }
    
    /**
     * Makes a maintenance request and creates an order
     * @param problem
     */
    public void makeFacilityMaintenanceRequest(String problem) {
        MaintenanceRequest request = new MaintenanceRequest(problem);
        requests.add(request);
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
    public void createOrder(String desc, Technician tech) {
        Order order = new Order(desc, orderNum, tech);
        orders.add(order);
        orderNum++;
    }
    
    /**
     * closes an order when finished
     * @param orderNum
     */
    public void closeOrder(int orderNum) {
        Order order = orders.get(orderNum);
        order.setStatus(true);
        log.addOrder(order);
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
    
    public void createTechnician(String name, int id) {
        Technician tech = new Technician(name, id);
        technicians.add(tech);
    }
    
    public Technician getTechnician(int id) {
        for (int i = 0; i < technicians.size(); i++) {
            if (technicians.get(i).getID() == id) {
                return technicians.get(i);
                }
            else {
                return null;
            }
        }
        return null;
    }
    
    public void removeTechnician(String name) {
        for (int i = 0; i < technicians.size(); i++) {
            if (technicians.get(i).getName().equals(name)) {
                technicians.remove(i);
            }
        }
    }
}
