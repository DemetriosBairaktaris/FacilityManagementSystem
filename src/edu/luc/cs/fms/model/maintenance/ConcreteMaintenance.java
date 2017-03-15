package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class is the interface between the client and the domain model for the
 * maintenance objects
 * 
 * @author TeamDK
 *
 */
public class ConcreteMaintenance implements Maintenance {

    private ConcreteLog log;
    private List<ConcreteMaintenanceRequest> requests;
    private List<ConcreteOrder> orders;
    private ConcreteSchedule schedule;
    private BigDecimal cost;
    private int orderNum;
    private int requestNum;
    private int numRequests;
    private SystemLog sysLog;
    ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");

    public ConcreteMaintenance(SystemLog sysLog) {
        this.sysLog = sysLog;
        //log = new ConcreteLog();
        //requests = new ArrayList<ConcreteMaintenanceRequest>();
        //orders = new ArrayList<ConcreteOrder>();
        //schedule = new ConcreteSchedule(sysLog);
        //cost = new BigDecimal("0");
        //orderNum = 0;
        //requestNum = 0;
        sysLog.logCreate(this);
    }
    
    public void setLog(ConcreteLog log) {
      this.log = log;
    };
    public ConcreteLog getLog() {
      return log;
    };
    public void setRequests(List<ConcreteMaintenanceRequest> requests) {
      this.requests = requests;
    };
    public List<ConcreteMaintenanceRequest> getRequests() {
      return requests;
    };
    public void setOrders(List<ConcreteOrder> orders) {
      this.orders = orders;
    };
    public List<ConcreteOrder> getOrders() {
      return orders;
    };
    public void setSchedule(ConcreteSchedule schedule) {
      this.schedule = schedule;
    };
    public ConcreteSchedule getSchedule() {
      return schedule;
    };
    public void setCost(BigDecimal cost) {
      this.cost = cost;
    };
    public BigDecimal getCost() {
      return cost;
    };
    public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
    };
    public int getOrderNum() {
      return orderNum;
    };
    public void setNumRequests(int numRequests) {
      this.numRequests = numRequests;
    };
    public int getNumRequests() {
      return numRequests;
    };
  

    @Override
    public void makeFacilityMaintRequest(String problem) {
      //TODO fix this
        ConcreteMaintenanceRequest request = (ConcreteMaintenanceRequest) context.getBean("request");
        request.setProblem(problem);
        request.setRequestNum(requestNum);
        request.log();
        requests.add(request);
        requestNum++;
    }

    @Override
    public boolean scheduleMaintenance(Date start, Date end) {
        return schedule.scheduleMaintenance(start, end);
    }

    @Override
    public BigDecimal calcMaintenanceCostForFacility() {
        for (int i = 0; i < orders.size(); i++) {
            cost = cost.add(orders.get(i).getCost());
        }
        return cost;
    }

    @Override
    public void createOrder(String desc, int requestNum) {
      //TODO fix this
        ConcreteOrder order = (ConcreteOrder) context.getBean("order");
        order.setLaborCost((LaborCost) context.getBean("labor"));
        order.setPartsCost((PartsCost) context.getBean("parts"));
        order.setDescription(desc);
        order.setOrderNum(requestNum);
        order.log();
        orders.add(order);
        orderNum++;
        requests.get(requestNum).addOpenOrder();
    }

    @Override
    public void closeOrder(int orderNum, int requestNum) {
        ConcreteOrder order = orders.get(orderNum);
        
        order.setStatus(true);
        sysLog.logClose(order);
        log.addOrder(order);
        sysLog.logAdd(order, log);
        requests.get(requestNum).removeOpenOrder();
    }

    @Override
    public void closeRequest(int requestNum) {
        ConcreteMaintenanceRequest request = requests.get(requestNum);
        if (request.getOpenOrders() == 0) {
            request.setStatus(true);
            sysLog.logClose(request);
        } else {
            return;
        }
    }

    @Override
    public void setPartsCost(BigDecimal cost, int orderNum) {
        ConcreteOrder order = orders.get(orderNum);
        order.setLabor(cost);
    }

    @Override
    public void setLaborCost(BigDecimal cost, int orderNum) {
        ConcreteOrder order = orders.get(orderNum);
        order.setParts(cost);
    }

    @Override
    public float calcProblemRateForFacility() {
        numRequests = requests.size();
        return ((float) numRequests) / 365;
    }

    @Override
    public long calcDownTimeForFacility() {
        return schedule.calcDownTimeForFacility();
    }

    @Override
    public List<ConcreteMaintenanceRequest> listMaintRequests() {
        return requests;
    }

    @Override
    public List<ConcreteOrder> listMaintenance() {
        return log.getMaintenanceList();
    }

    @Override
    public String listFacilityProblems() {
        String problems = "Facility Problems:\n";

        if (requests.size() == 0) {
            return "No facility problems.";
        }

        for (int i = 0; i < requests.size(); i++) {
            problems = problems.concat(requests.get(i).getProblem() + "\n");
        }
        return problems;
    }

    @Override
    public String toString() {
        return "Facility Maintenance Record.";
    }
}
