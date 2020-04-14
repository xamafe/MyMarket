package dojo.supermarket.model.offer;

public class XForYOffer implements ISpecialOfferConditions {

	private double x;
	private double y;

	public XForYOffer(double x, double y) {
		this.x = x;
		this.y = y;

	}
	
	@Override
	public double appliesForQuantity() {
		return x;
	}

	@Override
	public SpecialOfferType getOfferType() {
		return SpecialOfferType.XForY;
	}

	@Override
	public double calculateFactor() {
		return y/x;
	}

}
