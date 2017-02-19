package edu.luc.cs.comp473.project1.user;

import edu.luc.cs.fms.model.facility.ConcreteFacilityManager;
import edu.luc.cs.fms.model.facility.FacilityManager;

public class User {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FacilityManager manager = new ConcreteFacilityManager();
        
        manager.addNewFacility("WTC", "Loyola University Chicago Water Tower Campus", "111 E. Pearson St.");
        manager.addNewFacility("LSC", "Loyola University Chicago Lake Shore Campus", "1032 W. Sheridan Rd.");
        
        
        
    }

}
