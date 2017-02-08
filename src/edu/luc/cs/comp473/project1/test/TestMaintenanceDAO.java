package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.maintenance.MaintenanceRequest;
import edu.luc.cs.comp473.project1.dal.MaintenanceDAO; 

public class TestMaintenanceDAO {
    
    private MaintenanceRequest maintenanceRequest ; 
    private MaintenanceDAO DAO  ; 
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        String problem = "A problem that needs to be fixed" ; 
        maintenanceRequest = new MaintenanceRequest(problem); 
        DAO = new MaintenanceDAO() ; 
        
    }

    @After
    public void tearDown() throws Exception {
        maintenanceRequest = null ;
    }

    @Test
    public void testInsertAndGetMaintenanceRequest() {
        int id = maintenanceRequest.getID() ;
        DAO.insertMaintenance(maintenanceRequest);
        assertEquals(maintenanceRequest, DAO.getMaintenance(id));
    }

}
