package dojo.supermarket.printer;

import java.util.Locale;

import dojo.supermarket.model.Receipt;
import dojo.supermarket.model.ReceiptItem;
import dojo.supermarket.model.product.ProductUnit;

public abstract class AbstractReceiptPrinter {

	
	public abstract String printReceipt(Receipt receipt);
	

    protected static String presentQuantity(ReceiptItem item) {
        return ProductUnit.Each.equals(item.getProduct().getUnit())
                ? String.format("%x", (int)item.getQuantity())
                : String.format(Locale.GERMANY, "%.3f", item.getQuantity());
    }
}
