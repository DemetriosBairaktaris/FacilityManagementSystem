package edu.luc.cs.comp473.project1.model.facility;

import java.util.*;

import edu.luc.cs.comp473.project1.model.maintenance.MaintenanceRequest;

/**
 * This is an abstract class for concrete facilities to inherit.
 * @author TeamDK
 *
 */
public abstract class Facility {

    private String name;
    private String description;
    private String address;
    protected int numberOfRooms ;
    protected int roomCapacity ;
    private List<Room> rooms ; 
    private List<MaintenanceRequest> maintenance;
    //private int usage; //

    public Facility(String name, String desc, String address){
        this.rooms = new ArrayList<>();
        this.name = name ;
        this.description = desc ; 
        this.address = address ; 
    }
    /**
     * Retrieves a facility name.
     * 
     * @return name
     */
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
     * 
     * @return address
     */
    public String getAddress(){
        return address ; 
    }
    
    /**
     * String representation of a facility 
     * @return String 
     */
    @Override
    public String toString(){
        return this.name+ ":  "+ this.description+"\n"
        + "Address:  "+ this.address;
    }

    public void addMaintenance(MaintenanceRequest request) {
        maintenance.add(request);
    }
    
    public MaintenanceRequest getMaintenance() {
        return maintenance.get(0);
    }
    
    /**
     * Retrieves all the rooms associated with this facility
     * 
     * @return list of Room objects
     */
    public List<Room> getRooms() {
        return rooms ; 
    }
    
    /**
     * creates all the rooms based on the child class's # of rooms and room capacities
     */
    protected void createRooms(){
        
        for (int i = 0 ; i < numberOfRooms ; i++){
            rooms.add(new Room(i,roomCapacity));
        }
    }

    /**
     * @return String 
     */
    public String getFacilityInformation() {
        // TODO
        return this.toString() + "\n" +
                "Available Capacity:  "+ this.requestAvailableCapacity();
        
    }

    /**
     * adds a details the facility
     * @param unknown
     */
    public void addFacilityDetail() {
        // TODO : Figure out parameter, figure out what "detail" means
    }

    /**
     * returns available capacity
     * @return availCapacity
     */
    public int requestAvailableCapacity() {
        //TODO have this go through all rooms in all buildings to calculate capacity
        int availCapacity = 0;
        for (Room room : rooms){
            availCapacity += room.getAvailableCapacity();
        }
        return availCapacity;
    }
    
  /**Use Methods***********************************************/
    
    public void vacateFacility(){
        for (Room room: this.getRooms()){
           room.vacate();
        }
    }
    public boolean isInUseDuringInterval(){
        //TODO: figure out param
        return false ; 
    }
    public boolean assignFacilityToUse(Use use){
        //TODO
        return false;
    }
    public List<Inspection> listInspections(){
        //TODO
        return null ; 
    }
    public float listActualUsage(){
        //TODO
        return 0;
    }
    public float calcUsageRate(){
        //TODO
        return 0;
    }
}
