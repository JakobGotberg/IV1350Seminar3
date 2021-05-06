/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.integration;

import se.kth.IV1350.model.SaleDTO;

/**
 *
 * @author jakobgotberg
 */
public class Printer {
    
    /**
     * Creates a <code>Receipt</code> with information about the sale,
     * @param infoForReceipt A DTO with data concerning the sale.
     */
    
    public void printReceipt(SaleDTO infoForReceipt){
        
        Receipt receipt = new Receipt(infoForReceipt);
        
    }
    
}
