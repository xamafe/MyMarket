package dojo.supermarket.model;

import dojo.supermarket.model.product.Product;

public interface  ISupermarketCatalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);

}
