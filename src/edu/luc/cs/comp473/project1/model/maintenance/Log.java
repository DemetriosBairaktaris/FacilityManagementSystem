package edu.luc.cs.comp473.project1.model.maintenance;

import java.util.ArrayList;
import java.util.List;

public class Log {

    private List<Order> maintenance;
    
    public Log() {
        maintenance = new ArrayList<Order>();
    }
    
    public void addOrder(Order order) {
        maintenance.add(order);
    }
    
    public Order getOrder(int index) {
        return maintenance.get(index);
    }
    
    public List<Order> getMaintenanceList() {
        return maintenance;
    }
    
}
