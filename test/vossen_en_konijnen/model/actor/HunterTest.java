/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.model.actor;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vossen_en_konijnen.model.Field;
import vossen_en_konijnen.model.Location;

/**
 *
 * @author R
 */
public class HunterTest {
    
    public HunterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of act method, of class Hunter.
     */
    @Test
    public void testAct() {
        System.out.println("act");
        List<Actor> newHunter = null;
        Hunter instance = null;
        instance.act(newHunter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Hunter.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Hunter instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Hunter.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Hunter instance = null;
        Location expResult = null;
        Location result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Hunter.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Location newLocation = null;
        Hunter instance = null;
        instance.setLocation(newLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getField method, of class Hunter.
     */
    @Test
    public void testGetField() {
        System.out.println("getField");
        Hunter instance = null;
        Field expResult = null;
        Field result = instance.getField();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
