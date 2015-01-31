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
public class LynxTest {
    
    public LynxTest() {
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
     * Test of act method, of class Lynx.
     */
    @Test
    public void testAct() {
        System.out.println("act");
        List<Actor> newLynxes = null;
        Lynx instance = null;
        instance.act(newLynxes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxAge method, of class Lynx.
     */
    @Test
    public void testSetMaxAge() {
        System.out.println("setMaxAge");
        int age = 0;
        Lynx.setMaxAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBreedingAge method, of class Lynx.
     */
    @Test
    public void testSetBreedingAge() {
        System.out.println("setBreedingAge");
        int age = 0;
        Lynx.setBreedingAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBreedingProbability method, of class Lynx.
     */
    @Test
    public void testSetBreedingProbability() {
        System.out.println("setBreedingProbability");
        double chance = 0.0;
        Lynx.setBreedingProbability(chance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoodValue method, of class Lynx.
     */
    @Test
    public void testSetFoodValue() {
        System.out.println("setFoodValue");
        int value = 0;
        Lynx.setFoodValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxLitterSize method, of class Lynx.
     */
    @Test
    public void testSetMaxLitterSize() {
        System.out.println("setMaxLitterSize");
        int litterSize = 0;
        Lynx.setMaxLitterSize(litterSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingAge method, of class Lynx.
     */
    @Test
    public void testGetBreedingAge() {
        System.out.println("getBreedingAge");
        Lynx instance = null;
        int expResult = 0;
        int result = instance.getBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLynxBreedingAge method, of class Lynx.
     */
    @Test
    public void testGetLynxBreedingAge() {
        System.out.println("getLynxBreedingAge");
        int expResult = 0;
        int result = Lynx.getLynxBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAge method, of class Lynx.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        Lynx instance = null;
        int expResult = 0;
        int result = instance.getMaxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLynxAge method, of class Lynx.
     */
    @Test
    public void testGetMaxLynxAge() {
        System.out.println("getMaxLynxAge");
        int expResult = 0;
        int result = Lynx.getMaxLynxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingProbability method, of class Lynx.
     */
    @Test
    public void testGetBreedingProbability() {
        System.out.println("getBreedingProbability");
        Lynx instance = null;
        double expResult = 0.0;
        double result = instance.getBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLynxBreedingProbability method, of class Lynx.
     */
    @Test
    public void testGetLynxBreedingProbability() {
        System.out.println("getLynxBreedingProbability");
        double expResult = 0.0;
        double result = Lynx.getLynxBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLitterSize method, of class Lynx.
     */
    @Test
    public void testGetMaxLitterSize() {
        System.out.println("getMaxLitterSize");
        Lynx instance = null;
        int expResult = 0;
        int result = instance.getMaxLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLynxLitterSize method, of class Lynx.
     */
    @Test
    public void testGetMaxLynxLitterSize() {
        System.out.println("getMaxLynxLitterSize");
        int expResult = 0;
        int result = Lynx.getMaxLynxLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoodValue method, of class Lynx.
     */
    @Test
    public void testGetFoodValue() {
        System.out.println("getFoodValue");
        int expResult = 0;
        int result = Lynx.getFoodValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
