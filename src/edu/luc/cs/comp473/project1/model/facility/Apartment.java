package edu.luc.cs.comp473.project1.model.facility;

public class Apartment extends Facility {
    

    public Apartment(String name, String desc, String address){
        super(name,desc,address);
        this.numberOfRooms = 20 ; 
        this.roomCapacity = 1; 
        this.createRooms();
        
    }
}
