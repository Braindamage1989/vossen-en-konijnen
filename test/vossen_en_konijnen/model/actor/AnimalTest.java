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
public class AnimalTest {
    
    public AnimalTest() {
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
     * Test of act method, of class Animal.
     */
    @Test
    public void testAct() {
        System.out.println("act");
        List<Actor> newActors = null;
        Animal instance = null;
        instance.act(newActors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingProbability method, of class Animal.
     */
    @Test
    public void testGetBreedingProbability() {
        System.out.println("getBreedingProbability");
        Animal instance = null;
        double expResult = 0.0;
        double result = instance.getBreedingProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxLitterSize method, of class Animal.
     */
    @Test
    public void testGetMaxLitterSize() {
        System.out.println("getMaxLitterSize");
        Animal instance = null;
        int expResult = 0;
        int result = instance.getMaxLitterSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAge method, of class Animal.
     */
    @Test
    public void testGetMaxAge() {
        System.out.println("getMaxAge");
        Animal instance = null;
        int expResult = 0;
        int result = instance.getMaxAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreedingAge method, of class Animal.
     */
    @Test
    public void testGetBreedingAge() {
        System.out.println("getBreedingAge");
        Animal instance = null;
        int expResult = 0;
        int result = instance.getBreedingAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveBirth method, of class Animal.
     */
    @Test
    public void testGiveBirth() {
        System.out.println("giveBirth");
        List<Actor> newAnimals = null;
        Animal instance = null;
        instance.giveBirth(newAnimals);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUseGender method, of class Animal.
     */
    @Test
    public void testSetUseGender() {
        System.out.println("setUseGender");
        boolean bool = false;
        Animal.setUseGender(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMate method, of class Animal.
     */
    @Test
    public void testFindMate() {
        System.out.println("findMate");
        Animal animal = null;
        Animal instance = null;
        boolean expResult = false;
        boolean result = instance.findMate(animal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Animal.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 0;
        Animal instance = null;
        instance.setAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementHunger method, of class Animal.
     */
    @Test
    public void testIncrementHunger() {
        System.out.println("incrementHunger");
        Animal instance = null;
        instance.incrementHunger();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDead method, of class Animal.
     */
    @Test
    public void testSetDead() {
        System.out.println("setDead");
        Animal instance = null;
        instance.setDead();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementAge method, of class Animal.
     */
    @Test
    public void testIncrementAge() {
        System.out.println("incrementAge");
        Animal instance = null;
        instance.incrementAge();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoodLevel method, of class Animal.
     */
    @Test
    public void testSetFoodLevel() {
        System.out.println("setFoodLevel");
        int foodLevel = 0;
        Animal instance = null;
        instance.setFoodLevel(foodLevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Animal.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Location newLocation = null;
        Animal instance = null;
        instance.setLocation(newLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Animal.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Animal instance = null;
        Location expResult = null;
        Location result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getField method, of class Animal.
     */
    @Test
    public void testGetField() {
        System.out.println("getField");
        Animal instance = null;
        Field expResult = null;
        Field result = instance.getField();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canBreed method, of class Animal.
     */
    @Test
    public void testCanBreed() {
        System.out.println("canBreed");
        Animal instance = null;
        boolean expResult = false;
        boolean result = instance.canBreed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of breed method, of class Animal.
     */
    @Test
    public void testBreed() {
        System.out.println("breed");
        Animal instance = null;
        int expResult = 0;
        int result = instance.breed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Animal.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Animal instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class Animal.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Animal instance = null;
        boolean expResult = false;
        boolean result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Animal.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Animal instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AnimalImpl extends Animal {

        public AnimalImpl() {
            super(null, null, false);
        }

        public void act(List<Actor> newActors) {
        }

        public double getBreedingProbability() {
            return 0.0;
        }

        public int getMaxLitterSize() {
            return 0;
        }

        public int getMaxAge() {
            return 0;
        }

        public int getBreedingAge() {
            return 0;
        }
    }
    
}
