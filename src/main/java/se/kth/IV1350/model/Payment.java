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
public class Payment {
    
    private double totalPayment;
    private double totalVAT;
    
    public Payment(double totalPayment, double totalVAT){
        this.totalPayment = totalPayment;
        this.totalVAT = totalVAT;
    }
    
    public double getAmount(){
        return this.totalPayment;
    }
}
