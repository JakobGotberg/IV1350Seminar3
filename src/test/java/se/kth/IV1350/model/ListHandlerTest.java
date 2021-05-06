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
public class ListHandlerTest {
    
    

    @Test
    public void testAddProduct() {
        ListHandler handler = new ListHandler();
        Product[] list = new Product[3];
        Product product = new Product(15, 0.12, "Milk");
        int length = list.length;
        
        for(int i = 0; i < length; i++){
            list[i] = product;
        }
        list = handler.addProduct(list, product);
        boolean result = list.length == length +1;
        boolean expResult = true;
        assertEquals(expResult, result, "The values are not same. result: " + list.length + " expResult: " + length);
        
    }
    
}
