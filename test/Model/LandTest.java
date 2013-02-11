/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Unit test.
 */
public class LandTest {

    private Land l;    

    public LandTest() {
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

    @Test
    public void test1() {
        // Can be run when reader methods and default 
        // constructor are complete.
        l = new Land();
        try {
            assertTrue("Test 1: Default values are wrong.",
                    l.getLandName().equals("Empty") && l.getLandID() == -1);
            System.out.println("Test 1 completed successfully.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {        
        l = new Land(1, "Πορφυριές", "Χαλκίδα", 2, "Οικόπεδο", "Εντός Σχεδίου", 3500, "Ιδιόκτητο", 12);
        try {
            assertTrue("Test 2: Default values are wrong.",
                    l.getKAEK() == 2 && l.getLandName().equals("Πορφυριές") && l.getPersonID() == 12);
            System.out.println("Test 2 completed successfully.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
