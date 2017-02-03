package edu.luc.cs.comp473.project1.model.facility;

public class Room {
//
	private int roomNumber ; 
	private int capacity ; 
	private boolean available ;
	
	public Room(int roomNumber, int capacity){
		this.roomNumber = roomNumber ;
		this.capacity = capacity ;
		this.available = true ;
	}
	
	public void setAvailability(boolean v){
		this.available = v ;
	}
	
	public boolean isAvailable(){
		return this.available;
	}
}
