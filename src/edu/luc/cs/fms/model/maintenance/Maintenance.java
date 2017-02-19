package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface Maintenance {

    public void makeFacilityMaintRequest(String problem);

    public boolean scheduleMaintenance(Date date1, Date date2);

    public BigDecimal calcMaintenanceCostForFacility();

    public float calcProblemRateForFacility();

    public long calcDownTimeForFacility();

    public List<MaintenanceRequest> listMaintRequests();

    public List<Order> listMaintenance();

    public String listFacilityProblems();

    public void createOrder(String desc, int orderNum);

    public void setLaborCost(BigDecimal cost, int orderNum);

    public void setPartsCost(BigDecimal cost, int orderNum);

    public void closeRequest(int requestNum);

    public void closeOrder(int orderNum, int requestNum);

}
