
package edu.luc.cs.fms.model.facility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.luc.cs.fms.model.maintenance.ConcreteMaintenance;
import edu.luc.cs.fms.model.maintenance.ConcreteMaintenanceRequest;
import edu.luc.cs.fms.model.maintenance.Maintenance;
import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * Concrete Implementation of Facility
 * @author TeamDK
 * 
 */
public class Building implements Facility {
    
    private String name;
    private String description;
    private String address;
    private List<Room> rooms;
    private List<ConcreteInspection> inspections;
    private Maintenance maintenance;
    private ConcreteUse use;
    private SystemLog sysLog;
    
    public Building(String name, String desc, String address, SystemLog sysLog) {
        this.name = name;
        this.description = desc;
        this.address = address;
        //this.rooms = new ArrayList<>();
        //this.inspections = new ArrayList<>();
        this.sysLog = sysLog;
        sysLog.logCreate(this);
        //this.maintenance = new ConcreteMaintenance(sysLog);
        //this.use = new ConcreteUse(sysLog);
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
    public void setRooms(List<Room> rooms) {
      this.rooms = rooms;
    };
    public void setInspections(List<ConcreteInspection> inspections) {
      this.inspections = inspections;
    };
    public List<ConcreteInspection> getInspections() {
      return inspections;
    };
    public void setMaintenance(Maintenance maintenance) {
      this.maintenance = maintenance;
    };
    public void setUse(ConcreteUse use) {
      this.use = use;
    };
    public ConcreteUse getUse() {
      return use;
    };
    
    
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the facility description
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the facility address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return this.name + ":  " + this.description + "\n" + "Address:  " + this.address;
    }

    /**
     * Allows calling maintenance methods by retrieving object
     * @return Maintenance
     */
    public Maintenance getMaintenance() {
        return maintenance;
    }

    /**
     * Retrieves all the rooms associated with this facility
     * @return list of Room objects
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * @return String
     */
    public String getFacilityInformation() {
        return this.toString() + "\n" + "Available Capacity:  " + this.requestAvailableCapacity();
    }

    /**
     * adds a room to the facility
     * @param room
     */
    public void addFacilityDetail(Room room) {
        sysLog.logAdd(room, this);
        this.rooms.add(room);
    }

    /**
     * returns the available capacity
     * @return int
     */
    public int requestAvailableCapacity() {
        int availCapacity = 0;
        for (Room room : rooms) {
            availCapacity += room.getAvailableCapacity();
        }
        return availCapacity;
    }

    /**
     * vacates a facility and makes it available
     */
    public void vacateFacility() {
        sysLog.logVacate(this);
        for (Room room : this.getRooms()) {
            room.vacate();
        }
    }

    /**
     * Checks if facility is in use during a specified date range
     * @param start
     * @param end
     * @return boolean
     */
    public boolean isInUseDuringInterval(Date start, Date end) {
        return use.isInUseDuringInterval(start, end);
    }

    /**
     * assigns the facility to use for specified date range
     * @param start
     * @param end
     * @return boolean
     */
    public boolean assignFacilityToUse(Date start, Date end) {
        return use.assignFacilityToUse(start, end);
    }

    /**
     * lists all the inspection results if any
     * @return String
     */
    public String listInspections() {
        String inspectionResults = "Inspections:\n";

        if (inspections.size() == 0) {
            inspectionResults += "No Inspections done, yet";
        } else {
            for (ConcreteInspection i : inspections) {
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

    /**
     * lists the actual usage of the facility
     * @return String
     */
    public String listActualUsage() {
        return use.listActualUsage();
    }

    /**
     * determines the usage rate
     * @return double
     */
    public double calcUsageRate() {
        return use.calcUsageRate();
    }

    /**
     * checks if any maintenance requests are open
     * @return Inspection
     */
    public boolean inspect() {
        ConcreteInspection i = new ConcreteInspection(new Date(), sysLog);
        
        inspections.add(i);
        i.setPassed(true);
        for(ConcreteMaintenanceRequest m : maintenance.listMaintRequests()){
            if (!m.getStatus()){
                i.setPassed(false);
                break; 
            }
        }
        sysLog.logInspect(this);
        return i.getPassed();
    }
}
