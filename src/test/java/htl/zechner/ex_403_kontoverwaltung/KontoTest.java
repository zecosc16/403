/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.ex_403_kontoverwaltung;

import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oskar
 */
public class KontoTest {
    
    public KontoTest() {
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
     * Test of getAmount method, of class Konto.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Konto instance = null;
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class Konto.
     */
    @Test
    public void testWithdraw() throws Exception {
        System.out.println("withdraw");
        int m = 60;
        
        Konto k = new Konto(50, new JLabel());
        String expResult = "";
        try{
        String result = k.withdraw(30);
        
        assertEquals(true, true);
        }
        catch(NoMoneyException ex){
            assertEquals(false, true);
        }
        
       
    }

    /**
     * Test of deposit method, of class Konto.
     */
    @Test
    public void testDeposit() {
        
    }

    /**
     * Test of setLabel method, of class Konto.
     */
    @Test
    public void testSetLabel() {
       
    }
    
}
