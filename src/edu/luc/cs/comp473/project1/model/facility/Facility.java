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
    private List<Room> rooms ; 
    private List<Inspection> inspections ; 
    //private Maintenance maintenance ; 
    private Use use ; 

    public Facility(String name, String desc, String address){
        this.rooms = new ArrayList<>();
        this.name = name ;
        this.description = desc ; 
        this.address = address ; 
        this.use = new Use();
        this.inspections = new ArrayList<>();
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
        //maintenance.add(request);
    }
    public MaintenanceRequest getMaintenance() {
        //return maintenance.get(0);
        return null ; 
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
    public void addFacilityDetail(Room room) {
       this.rooms.add(room);
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
    public boolean isInUseDuringInterval(Date one, Date two){
        return use.isInUseDuringInterval(one,two); 
    }
    
    public boolean assignFacilityToUse(Date one, Date two){
        return use.assignFacilityToUse(one, two);
    }
    
    public String listInspections(){
        String inspectionResults = "Inspections:\n";
        if(inspections.size()==0){inspectionResults+="No Inspections done, yet";}
        else{
        
            for (Inspection i : inspections){
               inspectionResults = inspectionResults.concat(i.getDate()+":  ");
               if(i.getPassed()){
                   inspectionResults = inspectionResults.concat("passed\n");
               }
               else{
                   inspectionResults = inspectionResults.concat("failed\n");
               }
            }
        }
        return inspectionResults ;
    }
    
    public String listActualUsage(){
        return use.listActualUsage();
    }
    public double calcUsageRate(){
        return use.calcUsageRate();
    }
    public Inspection inspect(){
        Inspection i = new Inspection(new Date());
        inspections.add(i);
        return i ;
    }
}
