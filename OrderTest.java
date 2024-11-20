import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testSubtotalCalculationWithoutWaffleCone() {
        Order order = new Order();
        order.addItem(new IceCreamScoop(Factory.createFlavor("Mint Chocolate Chip"), 2));
        order.addItem(new ToppingItem(Factory.createTopping("Chocolate Chips"), 1));

        double expectedSubtotal = 2 * 2.80 + 0.50;
        assertEquals(expectedSubtotal, order.getSubtotal(), 0.01);
    }

    @Test
    void testSubtotalCalculationWithWaffleCone() {
        Order order = new Order();
        order.addItem(new IceCreamScoop(Factory.createFlavor("Chocolate Fudge"), 1));
        order.addItem(new ToppingItem(Factory.createTopping("Fresh Strawberries"), 2));
        order.setWaffleCone(true);

        double expectedSubtotal = 5.00 + 1 * 3.00 + 2 * 1.00;
        assertEquals(expectedSubtotal, order.getSubtotal(), 0.01);
    }

    @Test
    void testTaxCalculation() {
        Order order = new Order();
        order.addItem(new IceCreamScoop(Factory.createFlavor("Strawberry Swirl"), 3));
        order.setWaffleCone(false);

        double expectedSubtotal = 3 * 2.75;
        double expectedTax = expectedSubtotal * 0.08;
        assertEquals(expectedTax, order.getTax(), 0.01);
    }

    @Test
    void testTotalAmountCalculation() {
        Order order = new Order();
        order.addItem(new IceCreamScoop(Factory.createFlavor("Pistachio Delight"), 1));
        order.addItem(new ToppingItem(Factory.createTopping("Sprinkles"), 1));
        order.setWaffleCone(true);

        double expectedSubtotal = 5.00 + 3.25 + 0.30;
        double expectedTax = expectedSubtotal * 0.08;
        double expectedTotal = expectedSubtotal + expectedTax;
        assertEquals(expectedTotal, order.getTotal(), 0.01);
    }

    @Test
    void testInvoiceGeneration() {
        Order order = new Order();
        order.addItem(new IceCreamScoop(Factory.createFlavor("Chocolate Fudge"), 2));
        order.addItem(new ToppingItem(Factory.createTopping("Crushed Oreo"), 1));
        order.setWaffleCone(false);

        String filename = "test-invoice.txt";
        try {
            InvoiceGenerator.generateInvoice(order, filename);
        } catch (Exception e) {
            fail("Invoice generation failed: " + e.getMessage());
        }


        java.io.File file = new java.io.File(filename);
        assertTrue(file.exists());


        if (file.exists()) {
            file.delete();
        }
    }
}