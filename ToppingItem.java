public class ToppingItem extends OrderItem {
    private Topping topping;
    private int quantity;

    public ToppingItem(Topping topping, int quantity) {
        this.topping = topping;
        this.quantity = quantity;
    }

    @Override
    public double getPrice() {
        return topping.getPrice() * quantity;
    }

    @Override
    public String getDescription() {
        return topping.getName() + " - " + quantity + " time(s)";
    }
}