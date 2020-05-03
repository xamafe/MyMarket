package supermarket.model.offer;

public class XForAmountOffer implements ISpecialOfferConditions{
	private final double quantity;
	private final double discountAmount;
	private final double normalAmount;

	
	public XForAmountOffer(double quantity, double discountAmount, double normalAmount) {
		super();
		this.quantity = quantity;
		this.discountAmount = discountAmount;
		this.normalAmount = normalAmount;
	}
	
	@Override
	public double appliesForQuantity() {
		return quantity;
	}

	@Override
	public SpecialOfferType getOfferType() {
		return SpecialOfferType.XForAmount;
	}

	@Override
	public double calculateFactor() {
		return discountAmount / (quantity * normalAmount);
	}

	
}
