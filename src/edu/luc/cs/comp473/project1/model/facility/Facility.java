/**
 * 
 */
package edu.luc.cs.comp473.project1.model.facility;
import java.util.* ; 

public class Facility {
	
	private String name ;
	private String description; 
	private List<Building> buildings ; 
	private int usage ;  //
	
	public Facility(String name, String description){
		this.name = name ; 
		this.description = description ; 
		this.buildings = new ArrayList<>();
		this.usage = 0 ;  // Is 
	}
	
	public String getName(){
		return this.name ; 
	}
	
	public String getDescription(){
		return description ; 
	}
	
	public List<Building> getBuildings(){
		return buildings ; 
	}
	
	public String getFacilityInformation(){
		//TODO
		return "" ; 
	}
	
	public void addFacilityDetail(){
		//TODO : Figure out parameter, figure out what "detail" means	
	}
	
	public int requestAvailableCapacity(){
		int availCapacity = 0 ;
		return availCapacity ; 
	}
	
	public void createBuilding(String name, String description){
		this.buildings.add(new Building(name,description));
	}
	
	public void removeBuildingByName(String name){
		for(int i = 0 ; i < buildings.size(); i++){
			if(buildings.get(i).getName()==name){
				buildings.remove(i);
				break ; 
			}
		}
	}
	
	public boolean containsBuilding(String name){
		for (Building b : buildings){
			if (b.getName() == name){
				return true ;
			}
		}
		return false ;
	}
}
