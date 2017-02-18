package edu.luc.cs.comp473.project1.model.maintenance;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface Maintenance {

    public void makeFacilityMaintenanceRequest(String problem);
    public boolean scheduleMaintenance(Date date1, Date date2);
    public BigDecimal calcMaintenanceCostForFacility();
    public int calcProblemRateForFacility();
    public long calcDownTimeForFacility();
    public List<MaintenanceRequest> listMaintenanceRequests();
    public List<Order> listMaintenance();
    public String listFacilityProblems();
    
}
