package dojo.supermarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dojo.supermarket.model.ISupermarketCatalog;
import dojo.supermarket.model.Receipt;
import dojo.supermarket.model.ShoppingCart;
import dojo.supermarket.model.offer.ISpecialOfferConditions;
import dojo.supermarket.model.offer.Offer;
import dojo.supermarket.model.product.Product;
import dojo.supermarket.model.product.ProductQuantity;

public class MyMarketApp {

    private final ISupermarketCatalog catalog;
    private Map<Product, Offer> offers = new HashMap<>();

    public MyMarketApp(ISupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addSpecialOffer(ISpecialOfferConditions offerConditions, Product product, double argument) {
        this.offers.put(product, new Offer(offerConditions, product));
    }

    public Receipt checkOut(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<ProductQuantity> productQuantities = theCart.getItems();
		for (ProductQuantity pq : productQuantities) {
            Product p = pq.getProduct();
            double quantity = pq.getQuantity();
            double unitPrice = this.catalog.getUnitPrice(p);
            double price = quantity * unitPrice;
            receipt.addProduct(p, quantity, unitPrice, price);
        }
        theCart.handleOffers(receipt, this.offers, this.catalog);

        return receipt;
    }

}
