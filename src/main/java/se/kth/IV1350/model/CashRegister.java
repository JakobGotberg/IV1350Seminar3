/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 *
 * @author jakobgotberg
 */
public class CashRegister {
    
    private double amountInRegister;
    private double runningTotal;
    private double totalVAT;
    private double change;
    private double amountPayed;
    
    CashRegister(){
        this.runningTotal = 0;
        this.totalVAT = 0;
        this.change = 0;
        this.amountPayed = 0;
        
    }
    
    /**
     * Updates the running total and running VAT.
     * @param priceForProduct <code> priceForProduct</code>
     * @param VATForProduct <code> VATForProduct </code>
     */
    
    void update(double priceForProduct, double VATForProduct){
       this.runningTotal += priceForProduct;
       this.totalVAT += priceForProduct * VATForProduct;
    }
    
    /**
     * Calculates the change for the costumer. Line 53 is added for the test, which is generally unadvised but it doesn't interfere with the design or functionality.
     * The exception is added for a little extra flavor.
     * @param amountPayed
     * @return <code> change </code>
     * @throws Exception If <code> amountPayed </code> is less than <code> runningTotal </code>.
     */
    double calculateChange(double amountPayed) throws Exception{
        
        if(amountPayed >= this.runningTotal){
            this.amountPayed = amountPayed;
            this.change =  this.amountPayed - this.runningTotal;
            return this.change;
            
        }
        this.change = -1;
        throw new Exception("Amount payed is less than total price.");
    }
    
    double getRunningTotal(){
        return this.runningTotal;
    }
    
    double getTotalVAT(){
        return this.totalVAT;
    }
    
    double getChange(){
        return this.change;
    }
    
    double getAmountPayed(){
        return this.amountPayed;
    }
    
}
