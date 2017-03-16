package edu.luc.cs.fms.dal;

import edu.luc.cs.fms.model.facility.Facility;

import java.util.Map;

/**
 * This class performs the I/O for storage of Facility objects.
 * @author TeamDK
 */
public class ConcreteFacilityData implements FacilityData {

  private Map<Integer, Facility> facilityHashMap;

  public ConcreteFacilityData() {}
    
  @Override
  public void setFacilityHashMap(Map<Integer, Facility> facilityHashMap) {
    this.facilityHashMap = facilityHashMap;
  }

  @Override
  public Facility getFacility(String name) {
    return facilityHashMap.get(name.hashCode());
  }

  @Override
  public void insertFacility(Facility facility) {
    facilityHashMap.put(facility.getName().hashCode(), facility);
  }

  @Override
  public void removeFacility(String name) {
    facilityHashMap.remove(name.hashCode());
  }

  @Override
  public String toString() {
    String result = "Facilities:\n";
    if (facilityHashMap.size() == 0) {
      result += "None";
    } else {
      for (Integer i : facilityHashMap.keySet()) {
        result += "id:  " + i + "\n" + facilityHashMap.get(i).toString() + "\n";
      }
    }
    return result;
  }
}