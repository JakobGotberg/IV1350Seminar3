/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.controller;

import se.kth.IV1350.integration.Accounting;
import se.kth.IV1350.integration.Inventory;
import se.kth.IV1350.integration.Printer;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.Product;
import se.kth.IV1350.model.Sale;
import se.kth.IV1350.model.ViewInfoDTO;

   
/**
 * Controller class. 
 * @author jakobgotberg
 */
public class Controller {
    
    private Sale sale;
    private Inventory inventory;
    private Accounting accounting;

    
    /**
     * Initiates a sale, creating the necessary objects.
     */
    public void startSale(){
        this.sale = new Sale();
        this.inventory = new Inventory();
        this.accounting = new Accounting();
    }
    
    /**
     * Checks if the product is in the DB, currently its will always return a product, since we do not need to include exceptions in this assigment.
     * @param itemDescription ItemDescription.
     * @return returns DTO.
     */
    
    public ViewInfoDTO registerProduct(String itemDescription){
        
        Product productInQuestion = this.inventory.lookUpProduct(itemDescription);
        return this.sale.registerProduct(productInQuestion);
    }
    
    /**
     * Ends the current sale.
     * @return Returns a DTO containing the total cost and total VAT.
     */
    public Payment endSale(){
        Payment payment = this.sale.getAmountToPay();
        this.accounting.registerSale(payment);
        return payment;
    }
    
    /**
     * If the paid amount is greater than total price, this method will return an amount equal or greater than zero in change.
     * If not it will throw an exception and return zero in change. The costumer can in that case try again until the amount is greater or equal to the total price.
     * @param amountPayed The paid amount.
     * @return <code>change</code>
     */
    public double pay(double amountPayed){
        
        try{
        double change = this.sale.pay(amountPayed);
        this.accounting.updateFinance( this.sale.getAmountToPay() );
        
        this.inventory.updateInventory( this.sale.getListOfProducts() );
        
        Printer printer = new Printer();
        printer.printReceipt( this.sale.creatSaleDTO() );
        
        return change;
        }catch (Exception a){
            System.out.print(a);
            return 0;
        }
    }
    
    
    
}
