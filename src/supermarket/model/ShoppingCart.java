package supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import supermarket.model.offer.Offer;
import supermarket.model.offer.SpecialOfferType;
import supermarket.model.product.Product;
import supermarket.model.product.ProductQuantity;

public class ShoppingCart {

	private final List<ProductQuantity> itemList = new ArrayList<>();
	Map<Product, Double> productQuantities = new HashMap<>();

	public void handleOffers(Receipt receipt, Map<Product, Offer> offers, ISupermarketCatalog catalog) {
		productQuantities.keySet().stream().forEach(p -> {
			double quantity = productQuantities.get(p);
			if (offers.containsKey(p)) {
				Offer offer = offers.get(p);
				double unitPrice = catalog.getUnitPrice(p);
				int quantityAsInt = (int) quantity;
				Discount discount = null;
				int x = (int) offer.offerConditions.appliesForQuantity();
				if (getOfferType(offer) == SpecialOfferType.XForY) {
					if (quantityAsInt % x != 0) {
						double total = offer.getFactor() * (quantityAsInt / x) * x + quantityAsInt % x * unitPrice;
						double discountN = unitPrice * quantity - total;
						discount = new Discount(p, x + " für " + x / offer.getFactor(), discountN);
					}

				} else if (getOfferType(offer) == SpecialOfferType.XForY && quantity < x) {
					discount = new Discount(p, x + " für " + x / offer.getFactor(), 0);
				}
				if (getOfferType(offer) == SpecialOfferType.XForAmount) {
					double total = offer.getFactor() * (quantityAsInt / x) * x + quantityAsInt % x * unitPrice;
					double discountN = unitPrice * quantity - total;
					discount = new Discount(p, x + " für " + x * offer.getFactor() + " GE", discountN);
				}
				if (getOfferType(offer) == SpecialOfferType.PercentDiscount) {
					discount = new Discount(p, 1 - offer.getFactor() + " % Rabatt",
							quantity * unitPrice * offer.getFactor());
				}
				if (discount != null) {
					receipt.addDiscount(discount);
				}
			}

		});
	}

	private SpecialOfferType getOfferType(Offer offer) {
		return offer.offerConditions.getOfferType();
	}

	void addItem(Product product) {
		this.addItem(product, 1.0);
	}

	public void addItem(Product product, double quantity) {
		quantity = Math.ceil(quantity);
		itemList.add(new ProductQuantity(product, quantity));
		if (productQuantities.containsKey(product)) {
			productQuantities.put(product, productQuantities.get(product) + quantity);
		} else {
			productQuantities.put(product, quantity);
		}
	}

	public List<ProductQuantity> getItems() {
		return new ArrayList<>(itemList);
	}

	Map<Product, Double> productQuantities() {
		return productQuantities;
	}

}
