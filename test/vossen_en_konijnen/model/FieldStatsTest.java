/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.model;

import java.util.HashMap;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author R
 */
public class FieldStatsTest {
    
    public FieldStatsTest() {
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
     * Test of getPopulationDetails method, of class FieldStats.
     */
    @Test
    public void testGetPopulationDetails() {
        System.out.println("getPopulationDetails");
        Field field = null;
        FieldStats instance = new FieldStats();
        String expResult = "";
        String result = instance.getPopulationDetails(field);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCounters method, of class FieldStats.
     */
    @Test
    public void testGetCounters() {
        System.out.println("getCounters");
        FieldStats instance = new FieldStats();
        HashMap<Class, Counter> expResult = null;
        HashMap<Class, Counter> result = instance.getCounters();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistory method, of class FieldStats.
     */
    @Test
    public void testGetHistory() {
        System.out.println("getHistory");
        FieldStats instance = new FieldStats();
        HashMap<Class, LinkedList<Integer>> expResult = null;
        HashMap<Class, LinkedList<Integer>> result = instance.getHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class FieldStats.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        FieldStats instance = new FieldStats();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementCount method, of class FieldStats.
     */
    @Test
    public void testIncrementCount() {
        System.out.println("incrementCount");
        Class animalClass = null;
        FieldStats instance = new FieldStats();
        instance.incrementCount(animalClass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countFinished method, of class FieldStats.
     */
    @Test
    public void testCountFinished() {
        System.out.println("countFinished");
        FieldStats instance = new FieldStats();
        instance.countFinished();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHistory method, of class FieldStats.
     */
    @Test
    public void testAddHistory() {
        System.out.println("addHistory");
        FieldStats instance = new FieldStats();
        instance.addHistory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearHistory method, of class FieldStats.
     */
    @Test
    public void testClearHistory() {
        System.out.println("clearHistory");
        FieldStats instance = new FieldStats();
        instance.clearHistory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isViable method, of class FieldStats.
     */
    @Test
    public void testIsViable() {
        System.out.println("isViable");
        Field field = null;
        FieldStats instance = new FieldStats();
        boolean expResult = false;
        boolean result = instance.isViable(field);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
