package dojo.supermarket.model.offer;

import dojo.supermarket.model.product.Product;

public class Offer {
	public ISpecialOfferConditions offerConditions;
	private final Product product;

	public Offer(ISpecialOfferConditions offerCondition, Product product) {
		this.offerConditions = offerCondition;
		this.product = product;
	}

	Product getProduct() {
		return product instanceof Object ? this.product : null;
	}

	public double getFactor() {
		return offerConditions.calculateFactor();
	}

}
