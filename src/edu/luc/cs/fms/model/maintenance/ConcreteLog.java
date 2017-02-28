package edu.luc.cs.fms.model.maintenance;

import java.util.ArrayList;
import java.util.List;

/**
 * This log keeps track of completed orders for maintenance.
 * 
 * @author TeamDK
 *
 */
public class ConcreteLog {

    private List<ConcreteOrder> maintenance;

    public ConcreteLog() {
        maintenance = new ArrayList<ConcreteOrder>();
    }

    /**
     * adds an order to the log
     * @param order
     */
    public void addOrder(ConcreteOrder order) {
        maintenance.add(order);
    }

    /**
     * retrieves an order from the log
     * @param index
     * @return selected order
     */
    public ConcreteOrder getOrder(int index) {
        return maintenance.get(index);
    }

    /**
     * returns all orders
     * @return all orders
     */
    public List<ConcreteOrder> getMaintenanceList() {
        return maintenance;
    }

    @Override
    public String toString() {
        return "Completed Maintenance Log";
    }
}
