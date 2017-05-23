public class ShoppingTest {
    public static void main(String[] args) {
        itemTest();
    }

    private static void itemTest() {
        // Initialization test
        Item putty = new Item("Silly Putty", 90.50);
        Item plugs = new Item("Butt Plugs", 69.69, 25, 6969);
        // Item dumbass = new Item("Joe Timberlake", 20, -25, -10);

        // priceFor test
        System.out.println(putty.priceFor(20));
        System.out.println(plugs.priceFor(15));
        System.out.println(plugs.priceFor(25));

        // toString test
        System.out.println(putty);
        System.out.println(plugs);
    }
}
