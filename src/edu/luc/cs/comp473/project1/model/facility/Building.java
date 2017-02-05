package edu.luc.cs.comp473.project1.model.facility;

import java.util.*;

/**
 * This class creates building objects associated with a specific facility.
 * @author TeamDK
 *
 */
public class Building {
    //
    private String name;
    private String description;
    private List<Room> rooms;

    public Building(String name, String description) {
        this.name = name;
        this.description = description;
        this.rooms = new ArrayList<>();
    }

    /**
     * returns name of building
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns building description
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * returns available capacity
     * @return capacity
     */
    public int requestAvailableCapacity() {
        int availCapacity = 0;
        //TODO have this go through each building's room for available capacity
        return availCapacity;
    }
}
