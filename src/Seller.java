import java.util.Optional;

public class Seller {
    private String name;
    private Inventory inventory;

    public Seller(String PersonName, Inventory startingInventory) {
        name = PersonName;
        inventory = startingInventory;
    }

    public void buy(ItemInterface item) {
        inventory.addOne(item);
    }

    public Optional<ItemInterface> sell(String itemName) {
        Optional<ItemInterface> result = removeItem(itemName);
        return result;
    }

    public void addItem(ItemInterface item) {
        inventory.addOne(item);
    }

    public Optional<ItemInterface> removeItem(String itemName) {
        Optional<ItemInterface> result = inventory.removeOne(itemName);
        return result;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }
}
