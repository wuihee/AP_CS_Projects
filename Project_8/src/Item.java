import java.text.*;

public class Item {
    // Item stores items in the shopping cart.

    String name;
    private double price;
    private int bulkQuantity;
    private double bulkPrice;

    Item(String name, double price) {
        this.name = name;
        this.price = isNegativeValue(price, "price");
    }

    Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        this.price = isNegativeValue(price, "price");
        this.bulkQuantity = (int) isNegativeValue(bulkQuantity, "bulk quantity");
        this.bulkPrice = isNegativeValue(bulkPrice, "bulk price");
    }

    private double isNegativeValue(double value, String valueName) {
        // Throws and IllegalArgumentException if value is negative.
        if (value < 0) {
            throw new IllegalArgumentException("Negative " + valueName + ": " + value);
        }
        else {
            return value;
        }
    }

    double priceFor(int quantity) {
        // Returns the price for a given quantity of the item.
        quantity = (int) isNegativeValue(quantity, "quantity");
        if (bulkQuantity == 0) {
            return price * quantity;
        }
        // Take bulkPrice and bulkQuantity into consideration if they are defined.
        return price * (quantity % bulkQuantity) + bulkPrice * (quantity / bulkQuantity);
    }

    public String toString() {
        // 	Returns a String representation of this item.
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String priceText = nf.format(price);

        if (bulkQuantity > 0) {
            return name + ", $" + priceText + " ($" + bulkPrice + " for " + bulkQuantity + ")";
        }
        return name + ", $" + priceText;
    }
}
