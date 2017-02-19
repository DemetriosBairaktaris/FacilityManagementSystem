package edu.luc.cs.fms.user;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import edu.luc.cs.fms.model.facility.ConcreteFacilityManager;
import edu.luc.cs.fms.model.facility.FacilityManager;

/**
 * 
 * @author TeamDK
 *
 */
public class User {

    /**
     * Main method that simulates user level interaction
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FacilityManager manager = new ConcreteFacilityManager();
        Calendar dates = new GregorianCalendar();
        String wtc = "WTC";
        String lsc = "LSC";
        
        dates.set(2017, 5, 1);
        Date start = dates.getTime();
        dates.set(2017, 5, 5);
        Date end = dates.getTime();
        
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
        
        //WTC example
        manager.getFacility(wtc);
        manager.makeFacilityMaintRequest("Lights not working.");
        manager.makeFacilityMaintRequest("Broken Door");
        manager.scheduleMaintenance(start, end);
        manager.createOrder("Fix lights.", 0);
        manager.createOrder("Replace door", 1);
        manager.setLaborCost(new BigDecimal("2000"), 0);
        manager.setPartsCost(new BigDecimal("500"), 0);
        manager.setLaborCost(new BigDecimal("200"), 1);
        manager.setPartsCost(new BigDecimal("500"), 1);
        manager.closeOrder(0, 0);
        manager.closeRequest(0);
        manager.closeOrder(1, 1);
        manager.closeRequest(1);
        System.out.println(wtc + " Facility Cost: $" + manager.calcMaintenanceCostForFacility());
        System.out.println(wtc + " Facility Problem Rate: " + manager.calcProblemRateForFacility());
        
        
        //LSC example
    }

}
