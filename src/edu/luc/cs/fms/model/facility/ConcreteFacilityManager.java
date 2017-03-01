package edu.luc.cs.fms.model.facility;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import edu.luc.cs.fms.dal.ConcreteFacilityDAO;
import edu.luc.cs.fms.model.maintenance.ConcreteMaintenanceRequest;
import edu.luc.cs.fms.model.maintenance.ConcreteOrder;
import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * Concrete facility manager that interfaces with the user model
 * @author TeamDK
 *
 */
public class ConcreteFacilityManager implements FacilityManager {

    private ConcreteFacilityDAO facilities;
    private SystemLog log;
    private Facility currentFacility;

    public ConcreteFacilityManager() {
        facilities = new ConcreteFacilityDAO();
        log = new ConcreteSystemLog();
        log.logCreate(this);
    }

    @Override
    public String listFacilities() { 
        return facilities.toString();
    }

    @Override
    public void addNewFacility(String name, String desc, String address) {
        facilities.insertFacility(new Building(name, desc, address));
    }

    @Override
    public void removeFacility(String name) {
        facilities.removeFacility(name);
    }

    @Override
    public void addFacilityDetail(int roomNumber, int capacity) {
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
    public String currentFacility() {
        if (currentFacility == null) {
            return "No facility is being focused on.";
        } else {
            return "Current Facility Being Focused on:\n" + currentFacility.toString();
        }
    }

    @Override
    public String listRooms() {
        String result = "Rooms:\n";

        if (currentFacility.getRooms().size() == 0) {
            result += "None";
        } else {
            for (Room r : currentFacility.getRooms()) {
                result += "Room " + r.getRoomNumber() + " - Capacity " + r.getAvailableCapacity() + "\n";
            }
        }
        return result; 
    }

    @Override
    public boolean assignFacilityToUse(Date date1, Date date2){
       return currentFacility.assignFacilityToUse(date1, date2);
    }

    @Override
    public double calcUsageRate(){
        return currentFacility.calcUsageRate();
    }

    @Override
    public String listActualUsage() {
       return currentFacility.listActualUsage();
    }

    @Override
    public boolean isInUseDuringInterval(Date date1, Date date2){
        return currentFacility.isInUseDuringInterval(date1, date2);
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
    public List<ConcreteMaintenanceRequest> listMaintRequests() {
        return this.currentFacility.getMaintenance().listMaintRequests();
    }

    @Override
    public List<ConcreteOrder> listMaintenance() {
        return this.currentFacility.getMaintenance().listMaintenance();
    }

    @Override
    public String listFacilityProblems() {
        return this.currentFacility.getMaintenance().listFacilityProblems();
    }

    @Override
    public void createOrder(String desc, int requestNum) {
        this.currentFacility.getMaintenance().createOrder(desc, requestNum);
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

    @Override
    public String getFacilityInformation() {
        return currentFacility.toString();
    }

    @Override
    public int requestAvailableCapacity() {
        return currentFacility.requestAvailableCapacity();
    }

    @Override
    public void vacateFacility() {
        currentFacility.vacateFacility();
    }

    @Override
    public String listInspections() {
        return currentFacility.listInspections();
    }

    @Override
    public boolean inspect() {
        return currentFacility.inspect(); 
    }
}
