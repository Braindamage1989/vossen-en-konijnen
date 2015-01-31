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

/**
 *
 * @author R
 */
public class AbstractViewTest {
    
    public AbstractViewTest() {
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
     * Test of preparePaint method, of class AbstractView.
     */
    @Test
    public void testPreparePaint() {
        System.out.println("preparePaint");
        AbstractView instance = null;
        instance.preparePaint();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintChart method, of class AbstractView.
     */
    @Test
    public void testPaintChart() {
        System.out.println("paintChart");
        AbstractView instance = null;
        instance.paintChart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class AbstractView.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        AbstractView instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractViewImpl extends AbstractView {

        public AbstractViewImpl() {
            super(null, null, 0, 0);
        }

        public void preparePaint() {
        }

        public void paintComponent(Graphics g) {
        }
    }
    
}
