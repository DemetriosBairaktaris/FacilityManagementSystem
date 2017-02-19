
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
    private Facility currentFacility ; 
    
   
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
    public void getFacility(String name) {
        
       currentFacility =  facilities.getFacility(name);
    }

    @Override
    public String printCurrentFacility() {
        if (currentFacility ==null){
            return "No facility is being focused on.";
        }
        else{
            return "Current Facility Being Focused on:\n"+currentFacility.toString();
        }
    }
    
    public String listRooms(){
        String result = "Rooms:\n";
        if(currentFacility.getRooms().size()==0){
            result+="None"; 
        }
        else{
            for(Room r : currentFacility.getRooms()){
                result+="Room "+r.getRoomNumber()+" - Capacity "+r.getCapacity()+"\n";
            }
        }
        return result ; 
    }
}
