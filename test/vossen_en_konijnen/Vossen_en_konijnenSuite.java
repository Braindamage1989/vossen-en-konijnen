/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vossen_en_konijnen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author R
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({vossen_en_konijnen.view.ViewSuite.class, vossen_en_konijnen.controller.ControllerSuite.class, vossen_en_konijnen.model.ModelSuite.class, vossen_en_konijnen.SimulatorRunnerTest.class, vossen_en_konijnen.main.MainSuite.class})
public class Vossen_en_konijnenSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
