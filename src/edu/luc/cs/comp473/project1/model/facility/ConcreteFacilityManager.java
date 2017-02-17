
package edu.luc.cs.comp473.project1.model.facility;

import edu.luc.cs.comp473.project1.dal.FacilityDAO;
/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteFacilityManager implements FacilityManager {
    
    private FacilityDAO facilities ;
    
   
    public ConcreteFacilityManager(){
        facilities = new FacilityDAO();
    }
    
    /**
     * @return facilities
     */
    @Override
    public String listFacilities() { //figure that out
        return facilities.toString();
    }
    
    /**
     * @param facility
     */
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
    
    
    @Override
    public void addRoomToFacility(int roomNumber, int capacity, String name) {
        facilities.getFacility(name).addFacilityDetail(new BasicRoom(roomNumber, capacity));
    }
}
