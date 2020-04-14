package dojo.supermarket.model;

import java.util.Objects;

import dojo.supermarket.model.product.Product;

public class ReceiptItem {
    private final Product product;
    private final double pricePerUnit;
	private double totalPrice;
    private final double quantity;

    ReceiptItem(Product p, double quantity, double price, double totalPrice) {
    	super();
        this.product = p;
        this.quantity = quantity;
        this.pricePerUnit = price;
        this.totalPrice = totalPrice;
    }

    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
        	return true;
        }
        if (other == null || getClass() != other.getClass()) {
        	return false;
        }
        ReceiptItem that = (ReceiptItem) other;
        return this.pricePerUnit == that.pricePerUnit &&
        		this.totalPrice == that.totalPrice &&
        		this.quantity == that.quantity &&
        		this.product.equals(that.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product, pricePerUnit, totalPrice, quantity);
    }


}
