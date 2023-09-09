public class Wand implements ItemInterface {
    private Item item;

    public Wand(Item item) {
        this.item = item;
    }

    @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow("Wand", "A magic wand!", "100.0", String.valueOf(item.getExpiry()) + "");
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow("Wand", "100.0", column3);
    }
}
