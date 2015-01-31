/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.controller;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vossen_en_konijnen.model.Field;

/**
 *
 * @author R
 */
public class ControllerTest {
    
    public ControllerTest() {
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
     * Test of simulateOneStep method, of class Controller.
     */
    @Test
    public void testSimulateOneStep() {
        System.out.println("simulateOneStep");
        Controller instance = new Controller();
        instance.simulateOneStep();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hunderdSteps method, of class Controller.
     */
    @Test
    public void testHunderdSteps() {
        System.out.println("hunderdSteps");
        Controller instance = new Controller();
        instance.hunderdSteps();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Controller.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Controller instance = new Controller();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class Controller.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Controller instance = new Controller();
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Controller.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Controller instance = new Controller();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAbout method, of class Controller.
     */
    @Test
    public void testShowAbout() {
        System.out.println("showAbout");
        Controller instance = new Controller();
        instance.showAbout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRabbitCreationProbability method, of class Controller.
     */
    @Test
    public void testGetRabbitCreationProbability() {
        System.out.println("getRabbitCreationProbability");
        double expResult = 0.0;
        double result = Controller.getRabbitCreationProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoxCreationProbability method, of class Controller.
     */
    @Test
    public void testGetFoxCreationProbability() {
        System.out.println("getFoxCreationProbability");
        double expResult = 0.0;
        double result = Controller.getFoxCreationProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLynxCreationProbability method, of class Controller.
     */
    @Test
    public void testGetLynxCreationProbability() {
        System.out.println("getLynxCreationProbability");
        double expResult = 0.0;
        double result = Controller.getLynxCreationProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrassCreationProbability method, of class Controller.
     */
    @Test
    public void testGetGrassCreationProbability() {
        System.out.println("getGrassCreationProbability");
        double expResult = 0.0;
        double result = Controller.getGrassCreationProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHunterCreationProbability method, of class Controller.
     */
    @Test
    public void testGetHunterCreationProbability() {
        System.out.println("getHunterCreationProbability");
        double expResult = 0.0;
        double result = Controller.getHunterCreationProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRockCreationProbability method, of class Controller.
     */
    @Test
    public void testGetRockCreationProbability() {
        System.out.println("getRockCreationProbability");
        double expResult = 0.0;
        double result = Controller.getRockCreationProbability();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeFrame method, of class Controller.
     */
    @Test
    public void testMakeFrame() {
        System.out.println("makeFrame");
        int height = 0;
        int width = 0;
        Controller instance = new Controller();
        instance.makeFrame(height, width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Controller.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Class animalClass = null;
        Controller instance = new Controller();
        Color expResult = null;
        Color result = instance.getColor(animalClass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startDisease method, of class Controller.
     */
    @Test
    public void testStartDisease() {
        System.out.println("startDisease");
        Controller instance = new Controller();
        instance.startDisease();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showStatus method, of class Controller.
     */
    @Test
    public void testShowStatus() {
        System.out.println("showStatus");
        int step = 0;
        Field field = null;
        Controller instance = new Controller();
        instance.showStatus(step, field);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isViable method, of class Controller.
     */
    @Test
    public void testIsViable() {
        System.out.println("isViable");
        Field field = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.isViable(field);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRabbitCreationProbability method, of class Controller.
     */
    @Test
    public void testSetRabbitCreationProbability() {
        System.out.println("setRabbitCreationProbability");
        double probability = 0.0;
        Controller.setRabbitCreationProbability(probability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoxCreationProbability method, of class Controller.
     */
    @Test
    public void testSetFoxCreationProbability() {
        System.out.println("setFoxCreationProbability");
        double probability = 0.0;
        Controller.setFoxCreationProbability(probability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLynxCreationProbability method, of class Controller.
     */
    @Test
    public void testSetLynxCreationProbability() {
        System.out.println("setLynxCreationProbability");
        double probability = 0.0;
        Controller.setLynxCreationProbability(probability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGrassCreationProbability method, of class Controller.
     */
    @Test
    public void testSetGrassCreationProbability() {
        System.out.println("setGrassCreationProbability");
        double probability = 0.0;
        Controller.setGrassCreationProbability(probability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHunterCreationProbability method, of class Controller.
     */
    @Test
    public void testSetHunterCreationProbability() {
        System.out.println("setHunterCreationProbability");
        double probability = 0.0;
        Controller.setHunterCreationProbability(probability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRockCreationProbability method, of class Controller.
     */
    @Test
    public void testSetRockCreationProbability() {
        System.out.println("setRockCreationProbability");
        double probability = 0.0;
        Controller.setRockCreationProbability(probability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playSound method, of class Controller.
     */
    @Test
    public void testPlaySound() {
        System.out.println("playSound");
        String url = "";
        Controller.playSound(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Controller.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Class animalClass = null;
        Color color = null;
        Controller instance = new Controller();
        instance.setColor(animalClass, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
