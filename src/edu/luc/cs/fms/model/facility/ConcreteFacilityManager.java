
package edu.luc.cs.fms.model.facility;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import edu.luc.cs.fms.dal.FacilityDAO;
import edu.luc.cs.fms.model.maintenance.MaintenanceRequest;
import edu.luc.cs.fms.model.maintenance.Order;
import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteFacilityManager implements FacilityManager {

    private FacilityDAO facilities;
    private SystemLog log;
    private Facility currentFacility;

    public ConcreteFacilityManager() {
        facilities = new FacilityDAO();
        log = new ConcreteSystemLog();
        log.logCreate(this);
    }

    /**
     * @return facilities
     */
    @Override
    public String listFacilities() { // figure that out
        return facilities.toString();
    }

    @Override
    public void addNewFacility(String name, String desc, String address) {
        facilities.insertFacility(new Building(name, desc, address));
    }

    /**
     * @param facility
     * @return boolean
     */
    @Override
    public void removeFacility(String name) {
        facilities.removeFacility(name);

    }

    /*
     * @param roomNumber
     * 
     * @param capacity
     * 
     * @param name
     */
    @Override
    public void addRoomToFacility(int roomNumber, int capacity) {
        currentFacility.addFacilityDetail(new BasicRoom(roomNumber, capacity));
    }

    @Override
    public String toString() {
        return this.listFacilities();
    }

    @Override
    public void getFacility(String name) {

        currentFacility = facilities.getFacility(name);
    }

    @Override
    public String CurrentFacility() {
        if (currentFacility == null) {
            return "No facility is being focused on.";
        } else {
            return "Current Facility Being Focused on:\n" + currentFacility.toString();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.luc.cs.comp473.project1.model.facility.FacilityManager#listRooms()
     */
    @Override
    public String listRooms() {
        String result = "Rooms:\n";
        if (currentFacility.getRooms().size() == 0) {
            result += "None";
        } else {
            for (Room r : currentFacility.getRooms()) {
                result += "Room " + r.getRoomNumber() + " - Capacity " + r.getCapacity() + "\n";
            }
        }
        return result;
    }

    @Override
    public void makeFacilityMaintRequest(String problem) {
        this.currentFacility.getMaintenance().makeFacilityMaintRequest(problem);

    }

    @Override
    public boolean scheduleMaintenance(Date date1, Date date2) {
        return this.currentFacility.getMaintenance().scheduleMaintenance(date1, date2);
    }

    @Override
    public BigDecimal calcMaintenanceCostForFacility() {
        return this.currentFacility.getMaintenance().calcMaintenanceCostForFacility();
    }

    @Override
    public float calcProblemRateForFacility() {
        return this.currentFacility.getMaintenance().calcProblemRateForFacility();
    }

    @Override
    public long calcDownTimeForFacility() {
        return this.currentFacility.getMaintenance().calcDownTimeForFacility();
    }

    @Override
    public List<MaintenanceRequest> listMaintRequests() {
        return this.currentFacility.getMaintenance().listMaintRequests();
    }

    @Override
    public List<Order> listMaintenance() {
        return this.currentFacility.getMaintenance().listMaintenance();
    }

    @Override
    public String listFacilityProblems() {
        return this.currentFacility.getMaintenance().listFacilityProblems();
    }

    @Override
    public void createOrder(String desc, int orderNum) {
        this.currentFacility.getMaintenance().createOrder(desc, orderNum);

    }

    @Override
    public void setLaborCost(BigDecimal cost, int orderNum) {
        this.currentFacility.getMaintenance().setLaborCost(cost, orderNum);

    }

    @Override
    public void setPartsCost(BigDecimal cost, int orderNum) {
        this.currentFacility.getMaintenance().setPartsCost(cost, orderNum);

    }

    @Override
    public void closeRequest(int requestNum) {
        this.currentFacility.getMaintenance().closeRequest(requestNum);
    }

    @Override
    public void closeOrder(int orderNum, int requestNum) {
        this.currentFacility.getMaintenance().closeOrder(orderNum, requestNum);

    }

}
