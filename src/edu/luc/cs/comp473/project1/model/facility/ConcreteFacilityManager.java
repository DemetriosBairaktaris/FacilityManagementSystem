
package edu.luc.cs.comp473.project1.model.facility;

import edu.luc.cs.comp473.project1.dal.FacilityDAO;
import edu.luc.cs.comp473.project1.model.System.ConcreteSystemLog;
import edu.luc.cs.comp473.project1.model.System.SystemLog;
/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteFacilityManager implements FacilityManager {
    
    private FacilityDAO facilities ;
    private SystemLog log; 
    
   
    public ConcreteFacilityManager(){
        facilities = new FacilityDAO();
        log = new ConcreteSystemLog();
        log.logCreate(this);
    }
    
    /**
     * @return facilities
     */
    @Override
    public String listFacilities() { //figure that out
        return facilities.toString();
    }
    
    
    @Override
    public void addNewFacility(String name, String desc, String address) {
        facilities.insertFacility(new Building(name,desc,address));
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
     * @param capacity
     * @param name
     */
    @Override
    public void addRoomToFacility(int roomNumber, int capacity, String name) {
        facilities.getFacility(name).addFacilityDetail(new BasicRoom(roomNumber, capacity));
    }
    
    @Override
    public String toString(){
        return this.listFacilities();
    }

    @Override
    public Facility getFacility(String name) {
        
        return facilities.getFacility(name);
    }
}
