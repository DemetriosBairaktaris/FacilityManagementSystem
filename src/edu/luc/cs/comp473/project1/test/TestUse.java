package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.facility.Use;

public class TestUse {
    private Use use ; 

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        use = new Use();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testActivateUse() {
        fail("Not yet implemented");
        
    }

}
