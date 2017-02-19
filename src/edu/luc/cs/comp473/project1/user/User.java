package edu.luc.cs.comp473.project1.user;

import java.math.BigDecimal;

import edu.luc.cs.fms.model.facility.ConcreteFacilityManager;
import edu.luc.cs.fms.model.facility.FacilityManager;

public class User {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FacilityManager manager = new ConcreteFacilityManager();
        String wtc = "WTC";
        String lsc = "LSC";
        
        manager.addNewFacility(wtc, "Loyola University Chicago Water Tower Campus", "111 E. Pearson St.");
        manager.addNewFacility(lsc, "Loyola University Chicago Lake Shore Campus", "1032 W. Sheridan Rd.");
        
        for (int i = 100; i < 200; i += 10) {
            manager.getFacility(wtc);
            manager.addRoomToFacility(i, 40);
        }
        
        for (int i = 100; i < 400; i += 10) {
            manager.getFacility(lsc);
            manager.addRoomToFacility(i, 50);
        }
        
        manager.getFacility(wtc);
        manager.makeFacilityMaintRequest("Lights not working.");
        //TODO create maintenance request
        //manager.scheduleMaintenance(null, null);
        manager.createOrder("Fix lights.", 0);
        manager.setLaborCost(new BigDecimal("2000"), 0);
        manager.setPartsCost(new BigDecimal("500"), 0);
        manager.closeOrder(0, 0);
        manager.closeRequest(0);
        System.out.println(manager.calcMaintenanceCostForFacility());
        System.out.println(manager.calcProblemRateForFacility());
        
    }

}
