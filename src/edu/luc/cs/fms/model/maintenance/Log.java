package edu.luc.cs.fms.model.maintenance;

import java.util.ArrayList;
import java.util.List;

/**
 * This log keeps track of completed orders for maintenance.
 * 
 * @author TeamDK
 *
 */
public class Log {

    private List<Order> maintenance;

    public Log() {
        maintenance = new ArrayList<Order>();
    }

    /**
     * adds an order to the log
     * @param order
     */
    public void addOrder(Order order) {
        maintenance.add(order);
    }

    /**
     * retrieves an order from the log
     * @param index
     * @return selected order
     */
    public Order getOrder(int index) {
        return maintenance.get(index);
    }

    /**
     * returns all orders
     * @return all orders
     */
    public List<Order> getMaintenanceList() {
        return maintenance;
    }

    @Override
    public String toString() {
        return "Completed Maintenance Log";
    }
}
