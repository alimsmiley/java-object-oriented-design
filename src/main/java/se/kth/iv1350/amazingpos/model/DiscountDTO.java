
package se.kth.iv1350.amazingpos.model;

/**
 *
 * Contains information about the discount
 */
public class DiscountDTO {

    private double totalCostDiscount;
    private double itemDiscount;
    private double customerDiscount;

    /**
     * Creates a new instance of DiscountDTO.
     * @param totalCostDiscount Total discount on whole sale.
     * @param itemDiscount  Total discount on items.
     * @param customerDiscount  Total discount based on customer.
     */
    public DiscountDTO(double totalCostDiscount, double itemDiscount, double customerDiscount){
        this.totalCostDiscount = totalCostDiscount;
        this.itemDiscount = itemDiscount;
        this.customerDiscount = customerDiscount; 

    }

    /**
     * An overloaded constructor that creates a new instance of DiscountDTO given {@link discount}.
     * @param discount  A discount DTO to be copied.
     */
    public DiscountDTO(DiscountDTO discount){
        this.totalCostDiscount = discount.totalCostDiscount;
        this.itemDiscount = discount.itemDiscount;
        this.customerDiscount = discount.customerDiscount; 

    }


    public double getTotalCostDiscount(){
        return this.totalCostDiscount;
    }

    public double getItemDiscount(){
        return this.itemDiscount;      
    }
    
    public double getCustomerDiscount(){
        return this.customerDiscount; 
    }
    
    
}
