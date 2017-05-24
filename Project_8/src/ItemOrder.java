public class ItemOrder {
    private Item item;
    private int quantity;

    ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    double getPrice() {
        return item.priceFor(quantity);
    }

    String getItem() {
        return item.name;
    }
}
