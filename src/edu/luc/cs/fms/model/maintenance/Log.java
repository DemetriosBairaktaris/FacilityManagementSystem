package edu.luc.cs.fms.model.maintenance;

import java.util.List;

public interface Log {

  /**
   * Sets the list of maintenance objects.
   * @param maintenance list of orders
   */
  public void setMaintenance(List<Order> maintenance);

  /**
   * Adds an order to the log.
   * @param order Order
   */
  public void addOrder(Order order);

  /**
   * Retrieves an order from the log.
   * @param index integer
   * @return selected order
   */
  public Order getOrder(int index);

  /**
   * Returns all orders.
   * @return all orders list
   */
  public List<Order> getMaintenanceList();
}
