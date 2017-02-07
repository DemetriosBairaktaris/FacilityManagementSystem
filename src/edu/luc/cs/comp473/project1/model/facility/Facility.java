package edu.luc.cs.comp473.project1.model.facility;

import java.util.*;

import edu.luc.cs.comp473.project1.model.facility.Building;
import edu.luc.cs.comp473.project1.model.maintenance.MaintenanceRequest;

/**
 * This class creates Facility objects and controls buildings and rooms.
 * 
 * @author TeamDK
 *
 */
public class Facility {

    //TODO create method in here to generate an ID based on the name and to return it when called.
    private String name;
    private String description;
    private int id;
    private List<Building> buildings;
    private List<MaintenanceRequest> maintenance;
    private int usage; //

    public Facility(String name, String description) {
        this.name = name;
        this.description = description;
        usage = 0;
        id = name.hashCode();
    }

    /**
     * Retrieves a facility name.
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    public int getID() {
        return id;
    }

    /**
     * Retrieves the facility description
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void addMaintenance(MaintenanceRequest request) {
        maintenance.add(request);
    }
    
    /**
     * Retrieves all the buildings associated with this facility
     * 
     * @return list of buildings
     */
    public List<Building> getBuildings() {
        return buildings;
    }

    /**
     * 
     * @return
     */
    public String getFacilityInformation() {
        // TODO
        return "";
    }

    /**
     * 
     */
    public void addFacilityDetail() {
        // TODO : Figure out parameter, figure out what "detail" means
    }

    /**
     * returns available capacity
     * @return capacity
     */
    public int requestAvailableCapacity() {
        //TODO have this go through all rooms in all buildings to calculate capacity
        int availCapacity = 0;
        return availCapacity;
    }

    /**
     * creates a building object
     * @param name
     * @param description
     */
    public void createBuilding(String name, String description) {
        buildings.add(new Building(name, description));
    }

    /**
     * removes a building object from this facility
     * @param name
     */
    public void removeBuildingByName(String name) {
        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i).getName() == name) {
                buildings.remove(i);
                break;
            }
        }
    }

    /**
     * checks if building exists
     * @param name
     * @return boolean
     */
    public boolean containsBuilding(String name) {
        for (Building b : buildings) {
            if (b.getName() == name) {
                return true;
            }
        }
        return false;
    }
}
