public class Person {
    private String name;
    private Inventory inventory;

    public Person(String PersonName, Inventory startingInventory) {
        name = PersonName;
        inventory = startingInventory;
    }

    public void buy(ItemInterface item) {
        inventory.addOne(item);
    }

    public ItemInterface sell(String itemName) {
        ItemInterface result = removeItem(itemName);
        if (result != null) {
            return result;
        }
        return null;
    }

    public void addItem(ItemInterface item) {
        inventory.addOne(item);
    }

    public ItemInterface removeItem(String itemName) {
        return inventory.removeOne(itemName);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }
}
