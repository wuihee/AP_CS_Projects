public class Item {
    private String name;
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
        if (quantity % bulkQuantity == 0) {
            return bulkPrice * (quantity / bulkQuantity);
        }
        return price * quantity;
    }

    public String toString() {
        // 	Returns a String representation of this item.
        if (bulkQuantity > 0) {
            return name + ", $" + price + " ($" + bulkPrice + " for " + bulkQuantity + ")";
        }
        return name + ", $" + price;
    }
}
