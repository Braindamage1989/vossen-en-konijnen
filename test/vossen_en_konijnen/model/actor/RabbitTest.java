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
public class RabbitTest {
    
    public RabbitTest() {
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
     * Test of act method, of class Rabbit.
     */
    @Test
    public void testAct() {
        System.out.println("act");
        List<Actor> newRabbits = null;
        Rabbit instance = null;
        instance.act(newRabbits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxAge method, of class Rabbit.
     */
    @Test
    public void testSetMaxAge() {
        System.out.println("setMaxAge");
        int age = 0;
        Rabbit.setMaxAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBreedingAge method, of class Rabbit.
     */
    @Test
    public void testSetBreedingAge() {
        System.out.println("setBreedingAge");
        int age = 0;
        Rabbit.setBreedingAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBreedingProbability method, of class Rabbit.
     */
    @Test
    public void testSetBreedingProbability() {
        System.out.println("setBreedingProbability");
        double chance = 0.0;
        Rabbit.setBreedingProbability(chance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGrassFoodValue method, of class Rabbit.
     */
    @Test
    public void testSetGrassFoodValue() {
        System.out.println("setGrassFoodValue");
        int value = 0;
        Rabbit.setGrassFoodValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxLitterSize method, of class Rabbit.
     */
    @Test
    public void testSetMaxLitterSize() {
        System.out.println("setMaxLitterSize");
        int litterSize = 0;
        Rabbit.setMaxLitterSize(litterSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZiekte method, of class Rabbit.
     */
    @Test
    public void testSetZiekte() {
        System.out.println("setZiekte");
        boolean ziekte = false;
        Rabbit instance = null;
        instance.setZiekte(ziekte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingAge method, of class Rabbit.
     */
    @Test
    public void testGetBreedingAge() {
        System.out.println("getBreedingAge");
        Rabbit instance = null;
        int expResult = 0;
        int result = instance.getBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRabbitBreedingAge method, of class Rabbit.
     */
    @Test
    public void testGetRabbitBreedingAge() {
        System.out.println("getRabbitBreedingAge");
        int expResult = 0;
        int result = Rabbit.getRabbitBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAge method, of class Rabbit.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        Rabbit instance = null;
        int expResult = 0;
        int result = instance.getMaxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxRabbitAge method, of class Rabbit.
     */
    @Test
    public void testGetMaxRabbitAge() {
        System.out.println("getMaxRabbitAge");
        int expResult = 0;
        int result = Rabbit.getMaxRabbitAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingProbability method, of class Rabbit.
     */
    @Test
    public void testGetBreedingProbability() {
        System.out.println("getBreedingProbability");
        Rabbit instance = null;
        double expResult = 0.0;
        double result = instance.getBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRabbitBreedingProbability method, of class Rabbit.
     */
    @Test
    public void testGetRabbitBreedingProbability() {
        System.out.println("getRabbitBreedingProbability");
        double expResult = 0.0;
        double result = Rabbit.getRabbitBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLitterSize method, of class Rabbit.
     */
    @Test
    public void testGetMaxLitterSize() {
        System.out.println("getMaxLitterSize");
        Rabbit instance = null;
        int expResult = 0;
        int result = instance.getMaxLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxRabbitLitterSize method, of class Rabbit.
     */
    @Test
    public void testGetMaxRabbitLitterSize() {
        System.out.println("getMaxRabbitLitterSize");
        int expResult = 0;
        int result = Rabbit.getMaxRabbitLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrassFoodValue method, of class Rabbit.
     */
    @Test
    public void testGetGrassFoodValue() {
        System.out.println("getGrassFoodValue");
        int expResult = 0;
        int result = Rabbit.getGrassFoodValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZiekteGen method, of class Rabbit.
     */
    @Test
    public void testGetZiekteGen() {
        System.out.println("getZiekteGen");
        Rabbit instance = null;
        boolean expResult = false;
        boolean result = instance.getZiekteGen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZiekte method, of class Rabbit.
     */
    @Test
    public void testGetZiekte() {
        System.out.println("getZiekte");
        Rabbit instance = null;
        boolean expResult = false;
        boolean result = instance.getZiekte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
