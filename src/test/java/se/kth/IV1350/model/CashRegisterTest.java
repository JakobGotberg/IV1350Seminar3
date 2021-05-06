/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jakobgotberg
 */
public class CashRegisterTest {
    
    private CashRegister register1;
    private CashRegister register2;
    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        register1 = new CashRegister();
        register2 = new CashRegister();
    }
    
    @AfterEach
    public void tearDown() {
        register1 = null;
        register2 = null;
    }

    @Test
    public void testUpdate() {
        
        double priceForProduct = 100;
        double VATForProduct = 0.12;
        double expectedRunningTotal = 100;
        double expectedRunningVAT = 12.0;
        
        register1.update(priceForProduct, VATForProduct);
        double runningTotal = register1.getRunningTotal();
        double runningVAT = register1.getTotalVAT();
        boolean expResult = true;
        boolean result = ((runningTotal == expectedRunningTotal) && (runningVAT == expectedRunningVAT));
        assertEquals(expResult, result,"The values are equal.");
    }
    
    @Test
    public void testCalculateChange() throws Exception {
        double testAmount = 100;
        register1.update(testAmount, 0);
        double amountPayed = 120;
        
        double change = register1.calculateChange(amountPayed);
        double expChange = 20;
        boolean result = (change == expChange);
        boolean expResult = true;
        
        assertEquals(expResult, result, "The values are not same. expresult:" + change);
        
    }
    
    @Test
    public void testCalculateChangeNegativeChange() throws Exception {
        double testAmount = 100;
        register1.update(testAmount, 0);
        double amountPayed = 90;
        try{
        double change = register1.calculateChange(amountPayed);
        double expChange = -1;
        boolean result = (change == expChange);
        boolean expResult = true;
        
        assertEquals(expResult, result, "The method dosn't work, change is: " + change);
        }catch(Exception a){
            
        }
        
    }

     
}
