/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.model.Product;

/**
 *
 * @author jakobgotberg
 */
public class InventoryTest {
    
    @Test
    public void testLookUpProduct() {
        Inventory instance = new Inventory();
        Product product = instance.lookUpProduct("Bread");
        Product proTest = new Product(20, 0.12, "Bread");
        boolean result = proTest.getItemDescription() == product.getItemDescription() && proTest.getPrice() == product.getPrice() &&
                            proTest.getVAT() == product.getVAT() && proTest.getQuantity() == product.getQuantity();
        boolean expResult = true;
        assertEquals(expResult, result, "The values are not same.");
    }

    
    
}
