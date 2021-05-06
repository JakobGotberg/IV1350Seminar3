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
public class ViewInfoDTO {
    
    private String itemDescription;
    private double priceForProduct;
    private double runningTotal;
    private double runningVAT;
    private int quantity;
    
    private boolean notFound;
    
    public ViewInfoDTO(String itemDescription, double priceForProduct, double runningTotal, double runningVAT, int quantity){
        this.itemDescription = itemDescription;
        this.priceForProduct = priceForProduct;
        this.runningTotal = runningTotal;
        this.runningVAT = runningVAT;
    }
    
    
    public String getItemDescription() {
        return this.itemDescription;
    }
    
    public double getPriceForProduct(){
        return this.priceForProduct;
    }
    
    public double getRunningTotal(){
        return this.runningTotal;
    }
    
    public double getRunningVAT(){
        return this.runningVAT;
    }
}
