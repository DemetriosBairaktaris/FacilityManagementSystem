package edu.luc.cs.comp473.project1.dal;

import java.util.HashMap;

import edu.luc.cs.comp473.project1.model.maintenance.MaintenanceRequest;;

/**
 * This class is used for I/O of Maintenance Requests objects.
 * @author TeamDK
 *
 */
public class MaintenanceDAO {

    private int id;
    private HashMap<Integer, MaintenanceRequest> maintenanceMap;
    
    public MaintenanceDAO() {
        maintenanceMap = new HashMap<Integer, MaintenanceRequest>();
    }
    
    /**
     * This method retrieves a specific request.
     * @param id
     * @return MaintenanceRequest
     */
    public MaintenanceRequest getMaintenance(int id) {
        return maintenanceMap.get(id);
    }
    
    /**
     * This method stores a request.
     * @param request
     */
    public void insertMaintenance(MaintenanceRequest request) {
        maintenanceMap.put(id, request);
    }
    
    //TODO add method to acquire the ID from the request.
}
