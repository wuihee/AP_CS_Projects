import java.util.*;

public class Catalog {
    private String name;
    private ArrayList<Item> catalogItems = new ArrayList<>();

    Catalog(String name) {
         this.name = name;
    }

    void add(Item item) {
        // Adds an Item at the end of this list.
        catalogItems.add(item);
    }

    int size() {
        // Returns the number of items in this list.
        return catalogItems.size();
    }

    Item get(int index) {
        // Returns the Item with the given index (0-based).
        return catalogItems.get(index);
    }

    String getName() {
        // Returns the name of this catalog.
        return name;
    }
}
