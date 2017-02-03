package edu.luc.cs.comp473.project1.test;
import edu.luc.cs.comp473.project1.model.facility.*;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class FacilityTest {
	
	Facility facility ;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		facility = new Facility("FacilityName","FacilityDesc");
	}

	@After
	public void tearDown() throws Exception {
		facility = null ;
	}

	@Test
	public void testCreateBuilding() {
		String buildingName = "cafe" ; 
		String buildingDesc = "Serves food and drink" ;
		facility.createBuilding(buildingName,buildingDesc);
		Building newBuilding = facility.getBuildings().get(0);
		assertEquals(buildingName+buildingDesc,newBuilding.getName()+newBuilding.getDescription());
	}
	
	@Test
	public void testRemoveBuildingsByName(){
		String names [] = {"A","B","C","D","E","F","G"};
		for(int i = 0; i < 7; i++){
			facility.createBuilding(names[i],names[i]);
		}
		assertEquals(7,facility.getBuildings().size());
		assertTrue(facility.containsBuilding("D"));
		facility.removeBuildingByName("D");
		facility.removeBuildingByName("B");
		assertFalse(facility.containsBuilding("D"));
		assertFalse(facility.containsBuilding("B"));
	}
	

}
