
/**
 * This is the main class of the Campus Cafe Ordering System.
 * It creates customers, menu items, and orders.
 * @author Princes Rheamae
 * @version 1.0
 */
public class CafeApp {

    /**
     * Main method that runs the cafe ordering system.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       CAMPUS CAFE SYSTEM");
        System.out.println("==================================");

        // Create customers using different constructors.
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        // Create menu items using parameterized constructors.
        Beverage drink1 = new Beverage(
                "Iced Latte", 95, "B-01", "L");

        Pastry pastry1 = new Pastry(
                "Ensaymada", 45, "P-01", true);

        Meal meal1 = new Meal(
                "Chicken Adobo", 110, "M-01", true, 1);

        // Create menu items using default constructors.
        Beverage drink2 = new Beverage();
        drink2.setName("Hot Chocolate");
        drink2.setItemCode("B-02");

        // Demonstrate a setter rejecting an invalid price.
        drink2.setBasePrice(-5);

        // Set the correct price after the invalid attempt.
        drink2.setBasePrice(80);
        drink2.setSize("M");

        Meal meal2 = new Meal();
        meal2.setName("Beef Tapa");
        meal2.setBasePrice(130);
        meal2.setItemCode("M-02");
        meal2.setUpsized(false);
        meal2.setExtraSides(0);

        Pastry pastry2 = new Pastry();
        pastry2.setName("Cookie");
        pastry2.setBasePrice(30);
        pastry2.setItemCode("P-02");
        pastry2.setWarmed(false);

        // Create the first order.
        Order order1 = new Order("1001", customer1);

        order1.addItem(drink1);
        order1.addItem(pastry1);
        order1.addItem(meal1);

        // Try to add a fourth item.
        order1.addItem(pastry2);

        // Print the first receipt.
        order1.printReceipt();

        System.out.println("\n----------------------------------");

        // Create the second order.
        Order order2 = new Order("1002", customer2);

        order2.addItem(drink2);
        order2.addItem(meal2);

        // Calculate the second order with a 20 peso voucher.
        order2.computeTotal(20);

        // Print the second receipt.
        order2.printReceipt();

        System.out.println("\n==================================");
        System.out.println("       THANK YOU FOR ORDERING!");
        System.out.println("==================================");
    }
}
