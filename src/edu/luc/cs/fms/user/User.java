package edu.luc.cs.fms.user;

import edu.luc.cs.fms.model.facility.FacilityManager;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This simulates a user client.
 * @author TeamDK
 */
public class User {

  /**
   * Main method that simulates user level interaction.
   * @param args no args
   */
  public static void main(String[] args) {
        
    ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app-context.xml");
    
    //adding facilities
    FacilityManager manager = (FacilityManager) context.getBean("manager");
    String wtc = "WTC";
    String lsc = "LSC";
    manager.addNewFacility(wtc, "Loyola University Chicago Water Tower Campus",
        "111 E. Pearson St.");
    manager.addNewFacility(lsc, "Loyola University Chicago Lake Shore Campus",
        "1032 W. Sheridan Rd.");

    //adding rooms for wtc
    for (int i = 100; i < 200; i += 10) {
      manager.getFacility(wtc);
      manager.addFacilityDetail(i, 40);
    }

    //adding rooms for lsc
    for (int i = 100; i < 400; i += 10) {
      manager.getFacility(lsc);
      manager.addFacilityDetail(i, 50);
    }
        
    //listing facilities
    System.out.println(manager.listFacilities());

    //WTC example
    //maintenance
    manager.getFacility(wtc);
    manager.makeFacilityMaintRequest("Lights not working.");
    manager.makeFacilityMaintRequest("Broken Door");
    Calendar dates = new GregorianCalendar();
    dates.set(2017, 5, 1);
    Date start = dates.getTime();
    dates.set(2017, 5, 5);
    Date end = dates.getTime();
    manager.getFacility(wtc);
    manager.scheduleMaintenance(start, end);
    manager.createOrder("Fix lights.", 0);
    manager.createOrder("Replace door", 1);
    manager.setLaborCost(BigDecimal.valueOf(2000), 0);
    manager.setPartsCost(BigDecimal.valueOf(500), 0);
    manager.setLaborCost(BigDecimal.valueOf(200), 1);
    manager.setPartsCost(BigDecimal.valueOf(100), 1);
    manager.closeOrder(0, 0);
    manager.closeRequest(0);
    manager.closeOrder(1, 1);
    manager.closeRequest(1);
    System.out.println(wtc + " Facility Maintenance Cost: $" 
        + manager.calcMaintenanceCostForFacility());
    System.out.println(wtc + " Facility Problem Rate: " 
        + manager.calcProblemRateForFacility() + " per 365 days");
    System.out.println(wtc + " Down Time for Facility: " 
        + manager.calcDownTimeForFacility() + " days");
    System.out.println(wtc + " List of Maintenance Requests:");
    for (int i = 0; i < manager.listMaintRequests().size(); i++) {
      System.out.println(manager.listMaintRequests().get(i).toString() + "\n");
    }
    System.out.println(wtc + " List of Maintenance Performed:");
    for (int i = 0; i < manager.listMaintRequests().size(); i++) {
      System.out.println(manager.listMaintenance().get(i).toString() + "\n");
    }
    System.out.println(manager.listFacilityProblems());

    //usage
    dates.set(2017, 5, 3);
    Date date1 = dates.getTime();
    dates.set(2017, 5, 10);
    Date date2 = dates.getTime();
    manager.assignFacilityToUse(date1,date2);
    System.out.println(manager.listActualUsage());
    System.out.print("Available Capacity for " + manager.getFacilityInformation() + ":");
    System.out.println(manager.requestAvailableCapacity() + " open spots \n");
    System.out.println("Actual Usage for " + manager.getFacilityInformation());
    System.out.println(manager.listActualUsage());
    System.out.println("Usage Rate: " + (manager.calcUsageRate() * 100) + "% of year\n");
    System.out.println("Inspection passed: " + manager.inspect());
    System.out.println("List of Inspections: \n" + manager.listInspections());
    System.out.println("Facility in use during " + date1 + " - " + date2 + ":\n"
        + manager.isInUseDuringInterval(date1, date2));
    System.out.println();


    //LSC example
    //maintenance
    manager.getFacility(lsc);
    manager.makeFacilityMaintRequest("Hazmat needed in chem lab.");
    manager.makeFacilityMaintRequest("Broken Window.");
    manager.makeFacilityMaintRequest("Broken furniture in main hall.");
    manager.scheduleMaintenance(start, end);
    manager.createOrder("Call Hazmat.", 0);
    manager.createOrder("Monitor Hazmat cleanup", 0);
    manager.createOrder("Sanitize area after Hazmat.", 0);
    manager.createOrder("Replace glass panes in window.", 1);
    manager.createOrder("Replace with new furniture", 2);
    manager.setLaborCost(new BigDecimal("2000"), 0);
    manager.setPartsCost(new BigDecimal("0"), 0);
    manager.setLaborCost(new BigDecimal("300"), 1);
    manager.setPartsCost(new BigDecimal("0"), 1);
    manager.setLaborCost(new BigDecimal("400"), 2);
    manager.setPartsCost(new BigDecimal("100"), 2);
    manager.setLaborCost(new BigDecimal("800"), 3);
    manager.setPartsCost(new BigDecimal("1000"), 3);
    manager.setLaborCost(new BigDecimal("100"), 4);
    manager.setPartsCost(new BigDecimal("1200"), 4);
    manager.closeOrder(0, 0);
    manager.closeOrder(1, 0);
    manager.closeOrder(2, 0);
    manager.closeOrder(3, 1);
    manager.closeOrder(4, 2);
    manager.closeRequest(0);
    manager.closeRequest(1);
    manager.closeRequest(2);
    System.out.println(lsc + " Facility Maintenance Cost: $" 
        + manager.calcMaintenanceCostForFacility());
    System.out.println(lsc + " Facility Problem Rate: " 
         + manager.calcProblemRateForFacility() + " per 365 days");
    System.out.println(lsc + " Down Time for Facility: " 
         + manager.calcDownTimeForFacility() + " days");
    System.out.println(lsc + " List of Maintenance Requests:");
    for (int i = 0; i < manager.listMaintRequests().size(); i++) {
      System.out.println(manager.listMaintRequests().get(i).toString() + "\n");
    }
    System.out.println(lsc + " List of Maintenance Performed:");
    for (int i = 0; i < manager.listMaintenance().size(); i++) {
      System.out.println(manager.listMaintenance().get(i).toString() + "\n");
    }
    System.out.println(manager.listFacilityProblems());

    //usage
    manager.assignFacilityToUse(date1,date2);
    System.out.println(manager.listActualUsage());
    System.out.print("Available Capacity for " + manager.getFacilityInformation() + ":\n");
    System.out.println(manager.requestAvailableCapacity() + " open spots\n");
    System.out.println("Actual Usage for " + manager.getFacilityInformation());
    System.out.println(manager.listActualUsage());
    System.out.println("Usage Rate: " + (manager.calcUsageRate() * 100) + "% of year\n");
    System.out.println("Inspection passed: " + manager.inspect() + "\n");
    System.out.println("List of Inspections: \n" + manager.listInspections());
    System.out.println("Facility in use during " + date1 + " - " + date2 + ":\n"
        + manager.isInUseDuringInterval(date1, date2));
    System.out.println();

    //Removing facilities
    manager.removeFacility(lsc);
    manager.removeFacility(wtc);
    ((ConfigurableApplicationContext)context).close();
  }
}
