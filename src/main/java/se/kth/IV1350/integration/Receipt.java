/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.integration;

import java.util.Date;
import se.kth.IV1350.model.Product;
import se.kth.IV1350.model.SaleDTO;

/**
 *
 * @author jakobgotberg
 */
public class Receipt {
    
    private Product[] listOfProducts;
    private static String nameOfStore = "The Store";
    private double totalPayment;
    private double amountPayed;
    private double change;
    private double totalVAT;
    private Date timeOfSale;
    
    /**
     * Creates a receipt with all the necessary information about the sale. 
     * @param infoForReceipt 
     */
    Receipt(SaleDTO infoForReceipt){
        
        this.listOfProducts = infoForReceipt.getProductList();
        this.totalPayment = infoForReceipt.getTotalPayment();
        this.amountPayed = infoForReceipt.getAmountPayed();
        this.change = infoForReceipt.getChange();
        this.totalVAT = infoForReceipt.getTotalVAT();
        this.timeOfSale = java.util.Calendar.getInstance().getTime();
        
    }
    
}
