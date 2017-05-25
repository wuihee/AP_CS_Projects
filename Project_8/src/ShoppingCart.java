import java.util.*;

public class ShoppingCart {
    // ShoppingCart stores information about the overall order.

    private double discount = 1; // 1 refers to 100%.
    private ArrayList<ItemOrder> cart;

    ShoppingCart() {
        cart = new ArrayList<>();
    }

    void add(ItemOrder order) {
        // Adds an item order to the list, replacing any previous order for this item with the new order.
        boolean replace = false;
        int itemIdx = 0;

        for (ItemOrder i : cart) {
            if (i.getItem().equals(order.getItem())) {
                replace = true;
                break;
            }
            itemIdx++;
        }
        if (replace) {
            cart.remove(itemIdx);  // Remove repetition.
        }
        cart.add(order);
    }

    void setDiscount(boolean isDiscounted) {
        // Sets whether or not this order gets a discount (true means there is a discount, false means no discount).
        if (isDiscounted) {
            discount = 0.9;  // Set discount to 10%
        }
        else {
            discount = 1;
        }
    }

    double getTotal() {
        // Returns the total cost of the shopping cart.
        double totalPrice = 0.0;
        for (ItemOrder i : cart) {
            totalPrice += i.getPrice();
        }
        return totalPrice * discount;
    }
}
