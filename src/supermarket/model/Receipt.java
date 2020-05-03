package supermarket.model;

import java.util.ArrayList;
import java.util.List;

import supermarket.model.product.Product;

public class Receipt {
	private List<ReceiptItem> items = new ArrayList<>();
	private List<Discount> discounts = new ArrayList<>();

	public Double getTotalPrice() {
		double total = 0.0;

		total = this.items.stream()
					.mapToDouble(ReceiptItem::getTotalPrice)
					.reduce(0, (x, y) -> x + y);

	    total = this.discounts.stream()
	    			.map(Discount::getDiscountAmount)
	    			.reduce(total, (x, y) -> x - y);

		return total;
	}

	public void addProduct(Product p, double quantity, double price, double totalPrice) {
		this.items.add(new ReceiptItem(p, quantity, price, totalPrice));
	}

	public List<ReceiptItem> getItems() {
		return new ArrayList<ReceiptItem>(this.items);
	}

	public void addDiscount(Discount discount) {
		this.discounts.add(discount);
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}
}
