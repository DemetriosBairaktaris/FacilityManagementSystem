package edu.luc.cs.fms.model.maintenance;

import java.util.ArrayList;
import java.util.List;

/**
 * This log keeps track of completed orders for maintenance.
 * @author TeamDK
 *
 */
public class Log {

    private List<Order> maintenance;
    
    public Log() {
        maintenance = new ArrayList<Order>();
    }
    
    /**
     * 
     * @param order
     */
    public void addOrder(Order order) {
        maintenance.add(order);
    }
    
    /**
     * 
     * @param index
     * @return selected order
     */
    public Order getOrder(int index) {
        return maintenance.get(index);
    }
    
    /**
     * 
     * @return all maintenance performed
     */
    public List<Order> getMaintenanceList() {
        return maintenance;
    }
    
    @Override
    public String toString() {
        return "Completed Maintenance Log";
    }
}
