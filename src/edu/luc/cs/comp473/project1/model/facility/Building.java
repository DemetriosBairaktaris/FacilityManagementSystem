package edu.luc.cs.comp473.project1.model.facility;
import java.util.* ; 


public class Building {
	//
	private String name ; 
	private String description ;
	private List<Room> rooms ; 
	
	public Building(String name, String description){
		this.name = name ;
		this.description = description ; 
		this.rooms = new ArrayList<>();
	}
	
	public String getName(){
		return this.name ;
	}
	
	public String getDescription(){
		return this.description ; 
	}
	
	public int requestAvailableCapacity(){
		int availCapacity = 0 ;
		return availCapacity ; 
	}
	
	public String getBuildingInformation(){
		//TODO 
		return "" ; 
	}
}
