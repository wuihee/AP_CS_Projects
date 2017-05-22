public class Item {
    private static String name;
    private static double price;
    private static int bulkQuantity;
    private static double bulkPrice;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    }

    private static double priceFor(int quantity) {
        // Returns the price for a given quantity of the item.
        return 1.1;
    }
}
