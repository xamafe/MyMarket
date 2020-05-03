package supermarket.model;

import supermarket.model.product.Product;

public class Discount {
    private final double amount;
    private final Product product;
    private final String description;

	public Discount(Product product, String description, double discountAmount) {
    	super();
        this.product = product;
        this.description = description;
        this.amount = discountAmount;
    }


    public double getDiscountAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }
}
