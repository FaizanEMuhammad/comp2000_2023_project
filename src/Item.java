public class Item {
    private String name;
    private String description;
    private double value;
    private int expiry;

    public Item(String name, String description, double value, int expiry) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public int getExpiry() {
        return expiry;
    }

    
}
