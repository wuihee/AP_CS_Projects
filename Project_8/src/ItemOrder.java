public class ItemOrder {
    //  ItemOrder contains information about a particular item and the quantity ordered for that item.

    private Item item;
    private int quantity;

    ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    double getPrice() {
        // 	Returns the cost for this item order.
        return item.priceFor(quantity);
    }

    String getItem() {
        // Returns a reference to the item in this order.
        return item.name;
    }
}
