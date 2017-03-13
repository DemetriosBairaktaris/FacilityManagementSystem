package edu.luc.cs.fms.model.maintenance;

import java.util.List;

public interface Log {
  
    public void setMaintenance(List<ConcreteOrder> maintenance);
    public List<ConcreteOrder> getMaintenance();
  
    /**
     * adds an order to the log
     * @param order
     */
    public void addOrder(ConcreteOrder order);
    /**
     * retrieves an order from the log
     * @param index
     * @return selected order
     */
    public ConcreteOrder getOrder(int index);

    /**
     * returns all orders
     * @return all orders
     */
    public List<ConcreteOrder> getMaintenanceList();
}
