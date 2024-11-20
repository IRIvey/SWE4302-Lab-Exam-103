import java.io.FileWriter;
import java.io.IOException;

public class InvoiceGenerator {
    public static void generateInvoice(Order order, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Ice Cream Shop Invoice\n");
            for (OrderItem item : order.getItems()) {
                writer.write(item.getDescription() + ": $" + item.getPrice() + "\n");
            }
            writer.write("Subtotal: $" + order.getSubtotal() + "\n");
            writer.write("Tax: $" + order.getTax() + "\n");
            writer.write("Total Amount Due: $" + order.getTotal() + "\n");
        }
    }
}