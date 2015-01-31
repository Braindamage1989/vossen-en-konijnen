/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.controller;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
public class SliderControllerTest {
    
    public SliderControllerTest() {
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
     * Test of addSlider method, of class SliderController.
     */
    @Test
    public void testAddSlider() {
        System.out.println("addSlider");
        JPanel panel = null;
        JSlider s = null;
        String description = "";
        int majorTick = 0;
        int minorTick = 0;
        SliderController instance = new SliderController();
        instance.addSlider(panel, s, description, majorTick, minorTick);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of backToDefault method, of class SliderController.
     */
    @Test
    public void testBackToDefault() {
        System.out.println("backToDefault");
        SliderController instance = new SliderController();
        instance.backToDefault();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDefaultListener method, of class SliderController.
     */
    @Test
    public void testAddDefaultListener() {
        System.out.println("addDefaultListener");
        ActionListener listenForDefault = null;
        SliderController instance = new SliderController();
        instance.addDefaultListener(listenForDefault);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGenderListener method, of class SliderController.
     */
    @Test
    public void testAddGenderListener() {
        System.out.println("addGenderListener");
        ActionListener listenForGender = null;
        SliderController instance = new SliderController();
        instance.addGenderListener(listenForGender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemStateChanged method, of class SliderController.
     */
    @Test
    public void testItemStateChanged() {
        System.out.println("itemStateChanged");
        ItemEvent e = null;
        SliderController instance = new SliderController();
        instance.itemStateChanged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
