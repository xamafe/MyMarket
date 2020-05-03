package supermarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import supermarket.model.ISupermarketCatalog;
import supermarket.model.Receipt;
import supermarket.model.ShoppingCart;
import supermarket.model.offer.ISpecialOfferConditions;
import supermarket.model.offer.Offer;
import supermarket.model.product.Product;
import supermarket.model.product.ProductQuantity;

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
