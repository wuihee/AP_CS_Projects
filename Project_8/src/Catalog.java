import java.util.*;

public class Catalog {
    private String name;
    private ArrayList<Item> catalogItems = new ArrayList<>();

    Catalog(String name) {
         this.name = name;
    }

    void add(Item item) {
        catalogItems.add(item);
    }

    int size() {
        return catalogItems.size();
    }

    Item get(int index) {
        return catalogItems.get(index);
    }

    String getName() {
        return name;
    }
}
