/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

import java.util.Date;

/**
 *
 * @author jakobgotberg
 */
public class Sale {
    
        private Product[] listOfProducts;
        private ListHandler listHandler;
        private CashRegister cashregister;
        
        
        
    public Sale(){
          
            this.listOfProducts = new Product[0];
            this.listHandler = new ListHandler();
            this.cashregister = new CashRegister();
    }
       
    /**
     * Adds product to list, if the list is empty it will add it without checking for other copies.
     * @param productInQuestion The product in question.
     * @return returns DTO, <code>ViewInfoDTO</code>.
     */
    
    public ViewInfoDTO registerProduct(Product productInQuestion){
        
        if( listOfProducts.length == 0 ){    
            return addToList(productInQuestion);
        }
        
        int indexForProduct = checkIfAlreadyScanned(productInQuestion);
        if( indexForProduct >= 0 ){
            listOfProducts[indexForProduct].incrementQuantity();
            this.cashregister.update(productInQuestion.getPrice(), productInQuestion.getVAT());
            return createViewInfoDTO(productInQuestion);
        }
        
        return addToList(productInQuestion);
        
    }
    
    /**
     * Adds product to list of product, updates running total and VAT. New list is created and old one destroyed, see <code>ListHandler</code> for more info.
     * @param productInQuestion The product in question.
     * @return returns DTO, <code>ViewInfoDTO</code>.
     */
    private ViewInfoDTO addToList(Product productInQuestion){
       this.cashregister.update(productInQuestion.getPrice(), productInQuestion.getVAT());
       this.listOfProducts = listHandler.addProduct(listOfProducts, productInQuestion);
        
        return createViewInfoDTO(productInQuestion);
    }
    
    /**
     * Creates a DTO containing data about the registered product and total price.
     * @param productInQuestion The product in question.
     * @return DTO.
     */
    
    private ViewInfoDTO createViewInfoDTO(Product productInQuestion){
        
        ViewInfoDTO DTO = new ViewInfoDTO(productInQuestion.getItemDescription(),
                                            productInQuestion.getPrice(),
                                            this.cashregister.getRunningTotal(),
                                            this.cashregister.getTotalVAT(),
                                            productInQuestion.getQuantity());
        
        return DTO;
        
    }
    
    /**
     * If already registered, will return -1.
     * @param productInQuestion The product in question.
     * @return Index for list of products.
     */
    private int checkIfAlreadyScanned(Product productInQuestion){
            
            for(int i = 0; i < this.listOfProducts.length; i++){
                if( compareIstemDescriptionWithList(productInQuestion, i))
                    { return i; }
            } 
            return -1;    
        }
    
    private boolean compareIstemDescriptionWithList(Product productInQuestion, int index){
       return listOfProducts[index].getItemDescription().equalsIgnoreCase(productInQuestion.getItemDescription());
    }
    
    /**
     * Gets the required payment for purchase, using the cash register to calculate. If the costumer wishes to end the sale with no products
     * the program terminates here, to avoid sending unnecessary info to the external systems.
     * @return Payment, containing the total and total VAT.
     */
    public Payment getAmountToPay(){
        
        if( this.listOfProducts.length == 0)
            System.exit(0);
        
        Payment payment = new Payment(this.cashregister.getRunningTotal(), this.cashregister.getTotalVAT() );
        return payment;
    }
    
    /**
     * This method will return change, calculated with the cash register. 
     * If the paid amount is lower than the total price it will throw an exception and the costumer can try again.
     * @param amountPayed The amount the costumer payed.
     * @return <code>change</code>
     */
    public double pay(double amountPayed){
        
        try{
        return this.cashregister.calculateChange(amountPayed);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public Product[] getListOfProducts(){
        return this.listOfProducts;
    }
    
    /**
     * Creates DTO containing data about the sale.
     * @return DTO
     */
    public SaleDTO creatSaleDTO(){
        SaleDTO saleInfoForReceipt = new SaleDTO(this.listOfProducts,
                                                    this.cashregister.getRunningTotal(),
                                                      this.cashregister.getAmountPayed(),
                                                        this.cashregister.getChange(),
                                                          this.cashregister.getTotalVAT());
        return saleInfoForReceipt;
    }
        
}
