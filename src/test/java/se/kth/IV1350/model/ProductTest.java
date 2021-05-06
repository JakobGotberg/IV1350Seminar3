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
public class ProductTest {
    
    @Test
    public void testIncrementQuantity() {
        Product product = new Product(1500, 0.25, "Fender Stratocaster");
        product.incrementQuantity();
        int amount = product.getQuantity();
        int estimatedAmount = 2;
        boolean result = amount == estimatedAmount;
        boolean expResult = true;
        assertEquals(expResult, result, "The values are not same.");
        
    }

    
}
