package supermarket.model.offer;

public interface ISpecialOfferConditions {

	double appliesForQuantity();

	double calculateFactor();

	SpecialOfferType getOfferType();
}
