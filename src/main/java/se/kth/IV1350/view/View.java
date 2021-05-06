/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.view;

import se.kth.IV1350.controller.*;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.ViewInfoDTO;

/**
 *There is some bad smell in this class because of the duplicated code, but I didn't want to write any extra functions here,
 * since the view shouldn't have any logic in it.
 * @author jakobgotberg
 */
public class View {
    
    private Controller contr;
    
    public View(Controller contr){
        this.contr = contr;
    }
    
    public void hardCodedSale(){
        contr.startSale();
        
        ViewInfoDTO[] productList = new ViewInfoDTO[4];
        
       
        productList[0] = contr.registerProduct("Bread");
            System.out.println("itemDescription: " + productList[0].getItemDescription() );
            System.out.println("Price: " + productList[0].getPriceForProduct() + "$");
            System.out.println("Running total: " + productList[0].getRunningTotal() + "$");
            System.out.println("Running VAT: " + productList[0].getRunningVAT() + "$\n");
            
        productList[1] = contr.registerProduct("Bread");
            System.out.println("itemDescription: " + productList[1].getItemDescription() );
            System.out.println("Price: " + productList[1].getPriceForProduct() + "$");
            System.out.println("Running total: " + productList[1].getRunningTotal() + "$");
            System.out.println("Running VAT: " + productList[1].getRunningVAT() + "$\n");
            
        productList[2] = contr.registerProduct("EggCarton");
            System.out.println("itemDescription: " + productList[2].getItemDescription() );
            System.out.println("Price: " + productList[2].getPriceForProduct() + "$");
            System.out.println("Running total: " + productList[2].getRunningTotal() + "$");
            System.out.println("Running VAT: " + productList[2].getRunningVAT() + "$\n");
            
        productList[3] = contr.registerProduct("cookbook");
            System.out.println("itemDescription: " + productList[3].getItemDescription() );
            System.out.println("Price: " + productList[3].getPriceForProduct() + "$");
            System.out.println("Running total: " + productList[3].getRunningTotal() + "$");
            System.out.println("Running VAT: " + productList[3].getRunningVAT() + "$\n");
        
        System.out.println("Ending sale.");
        Payment toPayAndTax = contr.endSale();
        
        double toPay = toPayAndTax.getAmount();
        System.out.println("Total: " + toPay);
        contr.pay(toPay - 1);
        
        double change = contr.pay(toPay + 4);
        System.out.println("Thank you, your change is: " + change + "$. Please take your receipt.");
        
    }
    
}
