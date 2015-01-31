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
public class FoxTest {
    
    public FoxTest() {
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
     * Test of act method, of class Fox.
     */
    @Test
    public void testAct() {
        System.out.println("act");
        List<Actor> newFoxes = null;
        Fox instance = null;
        instance.act(newFoxes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxAge method, of class Fox.
     */
    @Test
    public void testSetMaxAge() {
        System.out.println("setMaxAge");
        int age = 0;
        Fox.setMaxAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBreedingAge method, of class Fox.
     */
    @Test
    public void testSetBreedingAge() {
        System.out.println("setBreedingAge");
        int age = 0;
        Fox.setBreedingAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBreedingProbability method, of class Fox.
     */
    @Test
    public void testSetBreedingProbability() {
        System.out.println("setBreedingProbability");
        double chance = 0.0;
        Fox.setBreedingProbability(chance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRabbitFoodValue method, of class Fox.
     */
    @Test
    public void testSetRabbitFoodValue() {
        System.out.println("setRabbitFoodValue");
        int value = 0;
        Fox.setRabbitFoodValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxLitterSize method, of class Fox.
     */
    @Test
    public void testSetMaxLitterSize() {
        System.out.println("setMaxLitterSize");
        int litterSize = 0;
        Fox.setMaxLitterSize(litterSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingAge method, of class Fox.
     */
    @Test
    public void testGetBreedingAge() {
        System.out.println("getBreedingAge");
        Fox instance = null;
        int expResult = 0;
        int result = instance.getBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoxBreedingAge method, of class Fox.
     */
    @Test
    public void testGetFoxBreedingAge() {
        System.out.println("getFoxBreedingAge");
        int expResult = 0;
        int result = Fox.getFoxBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAge method, of class Fox.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        Fox instance = null;
        int expResult = 0;
        int result = instance.getMaxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxFoxAge method, of class Fox.
     */
    @Test
    public void testGetMaxFoxAge() {
        System.out.println("getMaxFoxAge");
        int expResult = 0;
        int result = Fox.getMaxFoxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingProbability method, of class Fox.
     */
    @Test
    public void testGetBreedingProbability() {
        System.out.println("getBreedingProbability");
        Fox instance = null;
        double expResult = 0.0;
        double result = instance.getBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoxBreedingProbability method, of class Fox.
     */
    @Test
    public void testGetFoxBreedingProbability() {
        System.out.println("getFoxBreedingProbability");
        double expResult = 0.0;
        double result = Fox.getFoxBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLitterSize method, of class Fox.
     */
    @Test
    public void testGetMaxLitterSize() {
        System.out.println("getMaxLitterSize");
        Fox instance = null;
        int expResult = 0;
        int result = instance.getMaxLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxFoxLitterSize method, of class Fox.
     */
    @Test
    public void testGetMaxFoxLitterSize() {
        System.out.println("getMaxFoxLitterSize");
        int expResult = 0;
        int result = Fox.getMaxFoxLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRabbitFoodValue method, of class Fox.
     */
    @Test
    public void testGetRabbitFoodValue() {
        System.out.println("getRabbitFoodValue");
        int expResult = 0;
        int result = Fox.getRabbitFoodValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
