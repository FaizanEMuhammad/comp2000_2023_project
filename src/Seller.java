public class Seller extends Person{

    public Seller(String storeName, Inventory startingInventory) {
        super(storeName, startingInventory);
    }

    /**
     * Removes and returns an item from the held Inventory that matches
     * the `itemName` parameter.
     * @param itemName
     */
    public ItemInterface removeItem(String itemName) {
        return super.getInventory().removeOne(itemName);
    }
    
    public Inventory getInventory() {
        return super.getInventory();
    }

    public String getName() {
        return super.getName();
    }
    
}
