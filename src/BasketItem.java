public class BasketItem {
    private ItemInterface item;
    private int quantity;

    public BasketItem(ItemInterface item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ItemInterface getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qty) {
        quantity = qty;
    }
}
