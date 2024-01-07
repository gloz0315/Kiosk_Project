package kiosk.model;

public class Item extends Menu{
    private final double price;

    public Item(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double itemPrice() {
        return price;
    }
}
