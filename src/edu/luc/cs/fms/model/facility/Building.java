
package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.maintenance.Maintenance;
import edu.luc.cs.fms.model.maintenance.MaintenanceRequest;
import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Concrete Implementation of Facility.
 * @author TeamDK
 * 
 */
public class Building implements Facility {
    
  private String name;
  private String description;
  private String address;
  private List<Room> rooms;
  private List<Inspection> inspections;
  private Maintenance maintenance;
  private Use use;
  private SystemLog sysLog;
  private ApplicationContext context = 
      new ClassPathXmlApplicationContext("/META-INF/facility-context.xml"); 
  
  public Building() {/*default*/}
  
  @Override
  public void log() {
    sysLog.logCreate(this);
  }
  
  @Override
  public void setSysLog(SystemLog sysLog) {
    this.sysLog = sysLog ; 
  }
  
  @Override
  public void setDescription(String description) {
    this.description = description;
  }
  
  @Override
  public void setAddress(String address) {
    this.address = address;
  }
  
  @Override
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }
  
  @Override
  public void setInspections(List<Inspection> inspections) {
    this.inspections = inspections;
  }
  
  @Override
  public void setMaintenance(Maintenance maintenance) {
    this.maintenance = maintenance;
  }
  
  @Override
  public void setUse(Use use) {
    this.use = use;
  }
  
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return this.name + ":  " + this.description + "\n" + "Address:  " + this.address;
  }

  @Override
  public Maintenance getMaintenance() {
    return maintenance;
  }

  @Override
  public List<Room> getRooms() {
    return rooms;
  }

  @Override
  public String getFacilityInformation() {
    return this.toString() + "\n" + "Available Capacity:  " + this.requestAvailableCapacity();
  }

  @Override
  public void addFacilityDetail(Room room) {
    sysLog.logAdd(room, this);
    this.rooms.add(room);
  }

  @Override
  public int requestAvailableCapacity() {
    int availCapacity = 0;
    for (Room room : rooms) {
      availCapacity += room.getAvailableCapacity();
    }
    return availCapacity;
  }

  @Override
  public void vacateFacility() {
    sysLog.logVacate(this);
    for (Room room : this.getRooms()) {
      room.vacate();
    }
  }

  @Override
  public boolean isInUseDuringInterval(Date start, Date end) {
    return use.isInUseDuringInterval(start, end);
  }

  @Override
  public boolean assignFacilityToUse(Date start, Date end) {
    return use.assignFacilityToUse(start, end);
  }

  @Override
  public String listInspections() {
    String inspectionResults = "Inspections:\n";
    if (inspections.size() == 0) {
      inspectionResults += "No Inspections done, yet";
    } else {
      for (Inspection i : inspections) {
        inspectionResults = inspectionResults.concat(i.getDate() + ":  ");
        if (i.getPassed()) {
          inspectionResults = inspectionResults.concat("passed\n");
        } else {
          inspectionResults = inspectionResults.concat("failed\n");
        }
      }
    }
    return inspectionResults;
  }

  @Override
  public String listActualUsage() {
    return use.listActualUsage();
  }

  @Override
  public double calcUsageRate() {
    return use.calcUsageRate();
  }

  @Override
  public boolean inspect() {
    Inspection i = (Inspection) context.getBean("inspection");
    i.log();
    inspections.add(i);
    i.setPassed(true);
    for (MaintenanceRequest m : maintenance.listMaintRequests()) {
      if (!m.getStatus()) {
        i.setPassed(false);
        break; 
      }
    }
    sysLog.logInspect(this);
    return i.getPassed();
  }
}