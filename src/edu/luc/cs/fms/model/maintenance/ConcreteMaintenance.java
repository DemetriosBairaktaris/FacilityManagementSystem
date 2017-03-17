package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class is the interface between the client and the domain model for the
 * maintenance objects.
 * 
 * @author TeamDK
 *
 */
public class ConcreteMaintenance implements Maintenance {

  private Log log;
  private List<MaintenanceRequest> requests;
  private List<Order> orders;
  private Schedule schedule;
  private BigDecimal cost;
  private int requestNum;
  private int numRequests;
  private SystemLog sysLog;
  ApplicationContext context = 
      new ClassPathXmlApplicationContext("/META-INF/maintenance-context.xml");

  public ConcreteMaintenance() {/*default*/}

  @Override
  public void setLog(Log log) {
    this.log = log;
  }
  
  @Override
  public void setSysLog(SystemLog sysLog) {
    this.sysLog = sysLog ; 
  }
  
  @Override
  public void setRequests(List<MaintenanceRequest> requests) {
    this.requests = requests;
  }
  
  @Override
  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
  
  @Override
  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }
  
  @Override
  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }
  
  @Override
  public void setNumRequests(int numRequests) {
    this.numRequests = numRequests;
  }

  @Override
  public void makeFacilityMaintRequest(String problem) {
    MaintenanceRequest request = (MaintenanceRequest) context.getBean("request");
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
    Order order = (Order) context.getBean("order");
    order.setLaborCost((Cost) context.getBean("labor"));
    order.setPartsCost((Cost) context.getBean("parts"));
    order.setDescription(desc);
    order.setOrderNum(requestNum);
    order.log();
    orders.add(order);
    requests.get(requestNum).addOpenOrder();
  }

  @Override
  public void closeOrder(int orderNum, int requestNum) {
    Order order = orders.get(orderNum);
    order.setStatus(true);
    sysLog.logClose(order);
    log.addOrder(order);
    sysLog.logAdd(order, log);
    requests.get(requestNum).removeOpenOrder();
  }

  @Override
  public void closeRequest(int requestNum) {
    MaintenanceRequest request = requests.get(requestNum);
    if (request.getOpenOrders() == 0) {
      request.setStatus(true);
      sysLog.logClose(request);
    } else {
      return;
    }
  }

  @Override
  public void setPartsCost(BigDecimal cost, int orderNum) {
    Order order = orders.get(orderNum);
    order.setLabor(cost);
  }

  @Override
  public void setLaborCost(BigDecimal cost, int orderNum) {
    Order order = orders.get(orderNum);
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
  public List<MaintenanceRequest> listMaintRequests() {
    return requests;
  }

  @Override
  public List<Order> listMaintenance() {
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
