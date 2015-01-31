/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
public class FieldViewTest {
    
    public FieldViewTest() {
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
     * Test of getPreferredSize method, of class FieldView.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        FieldView instance = null;
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preparePaint method, of class FieldView.
     */
    @Test
    public void testPreparePaint() {
        System.out.println("preparePaint");
        FieldView instance = null;
        instance.preparePaint();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawMark method, of class FieldView.
     */
    @Test
    public void testDrawMark() {
        System.out.println("drawMark");
        int x = 0;
        int y = 0;
        Color color = null;
        FieldView instance = null;
        instance.drawMark(x, y, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class FieldView.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        FieldView instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
