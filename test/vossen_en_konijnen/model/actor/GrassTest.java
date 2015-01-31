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

/**
 *
 * @author R
 */
public class GrassTest {
    
    public GrassTest() {
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
     * Test of act method, of class Grass.
     */
    @Test
    public void testAct() {
        System.out.println("act");
        List<Actor> newGrass = null;
        Grass instance = null;
        instance.act(newGrass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMultiplyingAge method, of class Grass.
     */
    @Test
    public void testSetMultiplyingAge() {
        System.out.println("setMultiplyingAge");
        int age = 0;
        Grass.setMultiplyingAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxAge method, of class Grass.
     */
    @Test
    public void testSetMaxAge() {
        System.out.println("setMaxAge");
        int age = 0;
        Grass.setMaxAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMultiplyingProbability method, of class Grass.
     */
    @Test
    public void testSetMultiplyingProbability() {
        System.out.println("setMultiplyingProbability");
        double chance = 0.0;
        Grass.setMultiplyingProbability(chance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxMultiplyingSize method, of class Grass.
     */
    @Test
    public void testSetMaxMultiplyingSize() {
        System.out.println("setMaxMultiplyingSize");
        int size = 0;
        Grass.setMaxMultiplyingSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDead method, of class Grass.
     */
    @Test
    public void testSetDead() {
        System.out.println("setDead");
        Grass instance = null;
        instance.setDead();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultiplyingAge method, of class Grass.
     */
    @Test
    public void testGetMultiplyingAge() {
        System.out.println("getMultiplyingAge");
        int expResult = 0;
        int result = Grass.getMultiplyingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAge method, of class Grass.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        int expResult = 0;
        int result = Grass.getMaxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultiplyingProbability method, of class Grass.
     */
    @Test
    public void testGetMultiplyingProbability() {
        System.out.println("getMultiplyingProbability");
        double expResult = 0.0;
        double result = Grass.getMultiplyingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxMultiplyingSize method, of class Grass.
     */
    @Test
    public void testGetMaxMultiplyingSize() {
        System.out.println("getMaxMultiplyingSize");
        int expResult = 0;
        int result = Grass.getMaxMultiplyingSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canMultiply method, of class Grass.
     */
    @Test
    public void testCanMultiply() {
        System.out.println("canMultiply");
        Grass instance = null;
        boolean expResult = false;
        boolean result = instance.canMultiply();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Grass.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Grass instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
