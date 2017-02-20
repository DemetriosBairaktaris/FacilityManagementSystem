package edu.luc.cs.fms.model.facility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.luc.cs.fms.model.maintenance.ConcreteMaintenance;
import edu.luc.cs.fms.model.maintenance.Maintenance;
import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public abstract class Facility {

    private String name;
    private String description;

    private String address;
    private List<Room> rooms ; 
    private List<Inspection> inspections ; 
    private Maintenance maintenance ; 
    private Use use ;
    private SystemLog s ;
    
    /**
     * 
     * @param name
     * @param desc
     * @param address
     */
    public Facility(String name, String desc, String address){

        this.name = name ;
        this.description = desc ; 
        this.address = address ; 
        this.rooms = new ArrayList<>();
        this.inspections = new ArrayList<>();
        this.inspections = new ArrayList<>();
        s = new ConcreteSystemLog();
        s.logCreate(this);
        this.maintenance = new ConcreteMaintenance(s);
        this.use = new Use();
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
  
    /**
     * 
     * @return Maintenance
     */
    public Maintenance getMaintenance(){
        return maintenance;
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
     * @param room
     */
    public void addFacilityDetail(Room room) {
        s.logAdd(room,this);
       this.rooms.add(room);
    }

    /**
     * 
     * @return int
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
    
    /**
     * @return void
     */
    public void vacateFacility(){ //
        s.logVacate(this);
        for (Room room: this.getRooms()){
           room.vacate();
        }
        
    }
    /**
     * 
     * @param one
     * @param two
     * @return boolean
     */
    public boolean isInUseDuringInterval(Date one, Date two){ //
        return use.isInUseDuringInterval(one,two); 
    }
    
    /**
     * 
     * @param one
     * @param two
     * @return boolean
     */
    public boolean assignFacilityToUse(Date one, Date two){//
        return use.assignFacilityToUse(one, two);
    }
    
    /**
     * 
     * @return String
     */
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
    
    /**
     * 
     * @return String
     */
    public String listActualUsage(){//
        return use.listActualUsage();
    }
    
    /**
     * 
     * @return double
     */
    public double calcUsageRate(){ //
        return use.calcUsageRate();
    }
    
    /**
     * 
     * @return Inspection
     */
    public Inspection inspect(){ 
        s.logInspect(this);
        Inspection i = new Inspection(new Date());
        inspections.add(i);
        return i ;
    }
}
