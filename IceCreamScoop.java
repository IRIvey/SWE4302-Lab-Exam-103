public class IceCreamScoop extends OrderItem {
    private Flavor flavor;
    private int quantity;

    public IceCreamScoop(Flavor flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    @Override
    public double getPrice() {
        return flavor.getPrice() * quantity;
    }

    @Override
    public String getDescription() {
        return flavor.getName() + " - " + quantity + " scoop";
    }
}

