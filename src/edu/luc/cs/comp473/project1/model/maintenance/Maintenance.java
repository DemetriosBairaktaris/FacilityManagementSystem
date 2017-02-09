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
    
    public Maintenance() {
        log = new Log();
        requests = new ArrayList<MaintenanceRequest>();
        orders = new ArrayList<Order>();
        schedule = new Schedule();
        cost = new BigDecimal("0");
        orderNum = 0;
    }
    
    public void makeFacilityMaintenanceRequest(String problem) {
        MaintenanceRequest request = new MaintenanceRequest(problem);
        requests.add(request);
        createOrder(problem);
    }
    
    public boolean scheduleMaintenance(Date date1, Date date2) {
        return schedule.scheduleMaintenance(date1, date2);
    }
    
    public BigDecimal calcMaintenanceCostForFacility() {
        for (int i = 0; i < orders.size(); i++) {
            cost = cost.add(orders.get(i).getCost());
        }
        return cost;
    }
    
    private void createOrder(String desc) {
        Order order = new Order(desc, orderNum);
        orders.add(order);
        orderNum++;
    }
    
    public void closeOrder(int orderNum) {
        Order order = orders.get(orderNum);
        order.setStatus(true);
        log.addOrder(order);
    }
    
    public void setPartsCost(BigDecimal cost, int orderNum) {
        Order order = orders.get(orderNum);
        order.setLaborCost(cost);
    }
    
    public void setLaborCost(BigDecimal cost, int orderNum) {
        Order order = orders.get(orderNum);
        order.setPartsCost(cost);
    }
    
    public int calcProblemRateForFacility() {
        numRequests = requests.size();
        return numRequests / 365;
    }
    
    public long calcDownTimeForFacility() {
        return schedule.calcDownTimeForFacility();
    }
    
    public List<MaintenanceRequest> listMaintenanceRequests() {
        return requests;
    }
    
    public List<Order> listMaintenance() {
        return log.getMaintenanceList();
    }
    
    public List<MaintenanceRequest> listFacilityProblems() {
        return null;
    }
}
