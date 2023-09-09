import java.util.ArrayList;
import java.util.Optional;

public class Basket implements BasketInterface {
    private ArrayList<BasketItem> items;

    private static int itemNotFound = -1;
    private static int setItemQuantity = 1;

    public Basket() {
        items = new ArrayList<>();
    }

    public int itemIndex(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItem().getInventoryTableRow().getColumnOne().equalsIgnoreCase(itemName)) {
                return i;
            }
        }
        return itemNotFound;
    }

    public ArrayList<CartTableRow> getRowData() {
        ArrayList<CartTableRow> data = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            data.add(items.get(i).getItem().getCartRow(items.get(i).getQuantity() + ""));
        }

        return data;
    }

    @Override
    public void setItemQuantity(String itemName, int qty) {
        int index = itemIndex(itemName);
        if (index != itemNotFound) {
            items.get(index).setQuantity(qty);
        }
    }

    public void add(ItemInterface item) {
        int index = itemIndex(item.getInventoryTableRow().getColumnOne());
        if (index != itemNotFound) {
            items.get(index).setQuantity(items.get(index).getQuantity() + setItemQuantity);
        } else {
            items.add(new BasketItem(item, setItemQuantity));
        }
    }

    @Override
    public void remove(String itemName) {
        int index = itemIndex(itemName);

        if (index != itemNotFound) {
            items.remove(index);
        }
    }

    @Override
    public void processTransaction(Player from, Seller to) {
        ArrayList<ItemInterface> transactionItems = new ArrayList<>();
        boolean rollback = false;
        // Remove/sell items from the `from` parameter
        for (int i = 0; i < items.size() && !rollback; i++) {
            for (int q = 0; q < items.get(i).getQuantity(); q++) {
                Optional<ItemInterface> saleItem = from.sell(items.get(i).getItem().getInventoryTableRow().getColumnOne());
                if (!saleItem.isPresent()) {
                    rollback = true;
                    break;  // Trigger transaction rollback
                }
                transactionItems.add(saleItem.get());
            }
        }

        if (rollback) {
            for (ItemInterface item : transactionItems) {
                from.buy(item);  // Return to `from`
            }
        } else {
            for (ItemInterface item : transactionItems) {
                to.buy(item);  // Have `to` buy each of the transaction items
            }
        }
    }

    @Override
    public void processTransaction(Seller from, Player to) {
        ArrayList<ItemInterface> transactionItems = new ArrayList<>();
        boolean rollback = false;
        // Remove/sell items from the `from` parameter
        for (int i = 0; i < items.size() && !rollback; i++) {
            for (int q = 0; q <  items.get(i).getQuantity(); q++) {
                Optional<ItemInterface> saleItem = from.sell(items.get(i).getItem().getInventoryTableRow().getColumnOne());
                if (!saleItem.isPresent()) {
                    rollback = true;
                    break;  // Trigger transaction rollback
                }
                transactionItems.add(saleItem.get());
            }
        }
        if (rollback) {
            for (ItemInterface item : transactionItems) {
                from.buy(item);  // Return to `from`
            }
        } else {
            for (ItemInterface item : transactionItems) {
                to.buy(item);  // Have `to` buy each of the transaction items
            }
        }
    }

}
