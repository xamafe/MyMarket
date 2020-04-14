package dojo.supermarket.model.offer;

public class PercentDiscountOffer implements ISpecialOfferConditions {

	private final double discount;

	/**
	 * 
	 * @param discount - der Faktor, um den ein Preis reduziert wird (20 % Rabatt = 0,2)
	 */
	public PercentDiscountOffer(double discount) {
		super();
		this.discount = discount;
	}
	
	@Override
	public double appliesForQuantity() {
		return 1;
	}

	@Override
	public SpecialOfferType getOfferType() {
		return SpecialOfferType.PercentDiscount;
	}

	@Override
	public double calculateFactor() {
		return 1 - discount;
	}

}
