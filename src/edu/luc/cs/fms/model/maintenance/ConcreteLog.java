package edu.luc.cs.fms.model.maintenance;

import java.util.List;

/**
 * This log keeps track of completed orders for maintenance.
 * 
 * @author TeamDK
 *
 */
public class ConcreteLog implements Log {

  private List<Order> maintenance;

  public ConcreteLog() {}

  @Override
  public void setMaintenance(List<Order> maintenance) {
    this.maintenance = maintenance;
  }

  @Override
  public void addOrder(Order order) {
    maintenance.add(order);
  }

  @Override
  public Order getOrder(int index) {
    return maintenance.get(index);
  }

  @Override
  public List<Order> getMaintenanceList() {
    return maintenance;
  }

  @Override
  public String toString() {
    return "Completed Maintenance Log";
  }
}