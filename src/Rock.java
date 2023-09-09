public class Rock implements ItemInterface{

    private Item item;

    public Rock(Item item) {
        this.item = item;
    }

    @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow("Rock", "Rock :D", "5.0", String.valueOf(item.getExpiry())+ "");
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow("Rock", "5.0", column3);
    }
}
