public class ShoppingTest {
    public static void main(String[] args) {
        // itemTest();
        catalogTest();
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

    private static void catalogTest() {
        Catalog list = new Catalog("Roosevelt CS Gift Catalog");
        list.add(new Item("Wannabe", 0.2));
        list.add(new Item("Dumbass", 0.1));
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.getName());
    }
}
