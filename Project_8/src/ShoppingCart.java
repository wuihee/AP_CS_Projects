import java.util.*;

public class ShoppingCart {
    private double discount = 1;
    private ArrayList<ItemOrder> cart;

    ShoppingCart() {
        cart = new ArrayList<>();
    }

    void add(ItemOrder order) {
        boolean replace = false;
        for (ItemOrder i : cart) {
            if (i.getItem().equals(order.getItem())) {
                replace = true;
            }
        }
        if (replace) {
            System.out.println("Do some shit");
        }
        else {
            cart.add(order);
            replace = false;
        }
    }

    void setDiscount(boolean isDiscounted) {
        if (isDiscounted) {
            discount = 0.9;  // Set discount to 10%
        }
        else {
            discount = 1;
        }
    }

    double getTotal() {
        double totalPrice = 0.0;
        for (ItemOrder i : cart) {
            totalPrice += i.getPrice();
        }
        return totalPrice * discount;
    }
}
