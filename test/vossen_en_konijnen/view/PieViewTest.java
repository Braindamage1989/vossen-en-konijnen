/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.view;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vossen_en_konijnen.model.FieldStats;

/**
 *
 * @author R
 */
public class PieViewTest {
    
    public PieViewTest() {
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
     * Test of updateStats method, of class PieView.
     */
    @Test
    public void testUpdateStats() {
        System.out.println("updateStats");
        FieldStats stats = null;
        PieView instance = null;
        instance.updateStats(stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preparePaint method, of class PieView.
     */
    @Test
    public void testPreparePaint() {
        System.out.println("preparePaint");
        PieView instance = null;
        instance.preparePaint();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintChart method, of class PieView.
     */
    @Test
    public void testPaintChart() {
        System.out.println("paintChart");
        PieView instance = null;
        instance.paintChart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class PieView.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        PieView instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
