/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.model;

import java.util.Random;
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
public class RandomizerTest {
    
    public RandomizerTest() {
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
     * Test of getRandom method, of class Randomizer.
     */
    @Test
    public void testGetRandom() {
        System.out.println("getRandom");
        Random expResult = null;
        Random result = Randomizer.getRandom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Randomizer.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Randomizer.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomZiekteGen method, of class Randomizer.
     */
    @Test
    public void testGetRandomZiekteGen() {
        System.out.println("getRandomZiekteGen");
        boolean expResult = false;
        boolean result = Randomizer.getRandomZiekteGen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomZiekte method, of class Randomizer.
     */
    @Test
    public void testGetRandomZiekte() {
        System.out.println("getRandomZiekte");
        boolean expResult = false;
        boolean result = Randomizer.getRandomZiekte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
