/**
 * 
 */
package edu.luc.cs.comp473.project1.model.maintenance;

/**
 * @author TeamDK
 *
 */
public class Technician {

    private String name;
    private int id;
    
    public Technician(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return id number
     */
    public int getID() {
        return id;
    }
}
