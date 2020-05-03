package supermarket.printer;

import java.util.Locale;

import supermarket.model.Receipt;
import supermarket.model.ReceiptItem;

public abstract class AbstractReceiptPrinter {

	public abstract String printReceipt(Receipt receipt);
	
    protected static String presentQuantity(ReceiptItem item) {
        /*return ProductUnit.Each.equals(item.getProduct().getUnit())
                ? String.format("%d", (int)item.getQuantity())
                : String.format(Locale.GERMANY, "%.3f", item.getQuantity()); */
    	return String.format(Locale.GERMANY, "%.3f", item.getQuantity());
    }
}