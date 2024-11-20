import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private boolean waffleCone;

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void setWaffleCone(boolean waffleCone) {
        this.waffleCone = waffleCone;
    }

    public double getSubtotal() {
        double subtotal = waffleCone ? 5.00 : 0;
        for (OrderItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double getTax() {
        return getSubtotal() * 0.08;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    public List<OrderItem> getItems() {
        return items;
    }
}