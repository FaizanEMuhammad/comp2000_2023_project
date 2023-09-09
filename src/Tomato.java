public class Tomato implements ItemInterface {
    private Item item;

    public Tomato(Item item) {
        this.item = item;
    }

    @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow("Tomato", "Red and round", "15.0", String.valueOf(item.getExpiry()) + "");
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow("Tomato", "15.0", column3);
    }
}
