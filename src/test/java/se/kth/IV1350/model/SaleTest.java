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
public class SaleTest {
    
    /**
     * BeforeEach and AfterEach not working, even though the correct code was added in pom.xml. Hence the instance of sale instead of a field. 
     */

    @Test
    public void testRegisterProduct() {
        
        Sale instance = new Sale();
        ViewInfoDTO testDTO = new ViewInfoDTO("Milk", 15, 15, 15 * 0.12, 1);
        Product product = new Product(15, 0.12, "Milk");
        
        ViewInfoDTO DTO = instance.registerProduct(product);
        
        boolean result = testDTO.getItemDescription() == DTO.getItemDescription() && testDTO.getPriceForProduct() == DTO.getPriceForProduct()
                            && testDTO.getRunningTotal() == DTO.getRunningTotal() && testDTO.getRunningVAT() == DTO.getRunningVAT();
        boolean expResult = true;
        assertEquals(expResult, result, "Not the same object.");
        
    }
    
    @Test
    public void testRegisterProductSameItemDescription() {
        
        Sale instance = new Sale();
        Product[] productListTest = new Product[2];
        Product product = new Product(15, 0.12, "Milk");
        productListTest[0] = product;
        productListTest[1] = product;
        
        instance.registerProduct(product);
        instance.registerProduct(product);
        
        Product[] productList = instance.getListOfProducts();
        
        boolean result = (productListTest[0].getItemDescription() == productList[0].getItemDescription() ) 
                      && ( productList.length == 1 ) && (productList[0].getQuantity() == 2);
      
        boolean expResult = true;
        assertEquals(expResult, result, "Not the same object.");
        
    }
    
    @Test
    public void testRegisterProductRegisterSeveral() {
        
        Sale instance1 = new Sale();
        
        
        for(int i = 0; i < 25; i++){
        instance1.registerProduct( new Product(15, 0.12, "Milk") );
        instance1.registerProduct( new Product(25, 0.12, "EggCarton") );
        instance1.registerProduct( new Product(20, 0.12, "Bread") );
        instance1.registerProduct( new Product(50, 0.25, "CookBook"));
        }

        int listSize = instance1.getListOfProducts().length;
        Product[] listOrProducts = instance1.getListOfProducts();
        
        boolean result = listSize == 4 && listOrProducts[0].getQuantity() == 25;
      
        boolean expResult = true;
        assertEquals(expResult, result, "Not the right length: " + listSize);
        
    }

   
   
}
