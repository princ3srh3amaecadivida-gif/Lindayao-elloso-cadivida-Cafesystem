
/**
 * This class handles customer orders in the cafe.
 * It stores the customer and up to three menu items.
 * @author Princes Rheamae
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    private double voucherUsed;

    /**
     * Creates an order for a customer.
     * @param orderId the order number
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
        voucherUsed = 0;
    }

    /**
     * Adds a menu item to the order.
     * Only three items are allowed.
     * @param item the menu item to add
     * @return true if added, otherwise false
     */
    public boolean addItem(MenuItem item) {

        // Do not accept an empty item.
        if (item == null) {
            System.out.println("Invalid menu item.");
            return false;
        }
        // Check if the order already has three items.
        else if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                    + item.getDescription() + ".");
            return false;
        }
        // Place the item in the first available field.
        else if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    /**
     * Calculates the subtotal of all menu items.
     * @return the subtotal
     */
    public double computeSubtotal() {

        double subtotal = 0;

        if (item1 != null) {
            subtotal = subtotal + item1.computePrice();
        }

        if (item2 != null) {
            subtotal = subtotal + item2.computePrice();
        }

        if (item3 != null) {
            subtotal = subtotal + item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Calculates the total with a student discount if applicable.
     * @return the final total
     */
    public double computeTotal() {

        double subtotal = computeSubtotal();
        double total = subtotal;

        // Students receive a 10 percent discount.
        if (customer.isStudent()) {
            total = subtotal - (subtotal * 0.10);
        } else {
            total = subtotal;
        }

        // No voucher is applied in this calculation.
        voucherUsed = 0;

        return total;
    }

    /**
     * Calculates the total with a voucher.
     * The student discount is also applied when applicable.
     * @param voucher the voucher amount
     * @return the final total after discounts
     */
    public double computeTotal(double voucher) {

        double total = computeTotal();

        // Do not allow a negative voucher.
        if (voucher < 0) {
            voucherUsed = 0;
            System.out.println("Invalid voucher amount.");
        } else {
            voucherUsed = voucher;
        }

        // The total cannot be lower than zero.
        total = total - voucherUsed;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    /**
     * Prints the order receipt and updates loyalty points.
     */
    public void printReceipt() {

        double subtotal = computeSubtotal();
        double discount = 0;
        double total;

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName());

        if (customer.isStudent()) {
            System.out.println("Student Customer");
            discount = subtotal * 0.10;
        }

        // Print the first item if it exists.
        if (item1 != null) {
            System.out.printf("  %s ............ %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        // Print the second item if it exists.
        if (item2 != null) {
            System.out.printf("  %s ............ %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        // Print the third item if it exists.
        if (item3 != null) {
            System.out.printf("  %s ............ %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        System.out.printf("  Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("  Student discount (10%%): -%.2f%n",
                    discount);
        }

        total = subtotal - discount - voucherUsed;

        if (total < 0) {
            total = 0;
        }

        if (voucherUsed > 0) {
            System.out.printf("  Voucher: -%.2f%n", voucherUsed);
        }

        System.out.printf("  TOTAL: %.2f%n", total);

        // Give loyalty points based on the amount spent.
        customer.addPoints(total);

        System.out.println("  Loyalty points: "
                + customer.getLoyaltyPoints());
    }

    /**
     * Gets the order ID.
     * @return the order ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the customer who placed the order.
     * @return the customer object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the number of items in the order.
     * @return the item count
     */
    public int getItemCount() {
        return itemCount;
    }
}
