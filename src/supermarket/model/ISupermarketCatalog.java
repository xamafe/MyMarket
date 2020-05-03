package supermarket.model;

import supermarket.model.product.Product;

public interface  ISupermarketCatalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);

}
