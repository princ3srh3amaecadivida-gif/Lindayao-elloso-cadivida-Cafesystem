
/**
 * This class stores the information of a cafe customer.
 * @author Princes Rheamae
 * @version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor.
     */
    public Customer() {
        name = "Unknown Customer";
        student = false;
        loyaltyPoints = 0;
    }

    /**
     * Constructor with customer name.
     * @param name the customer's name
     */
    public Customer(String name) {
        this.name = name;
        student = false;
        loyaltyPoints = 0;
    }

    /**
     * Constructor with name and student status.
     * @param name the customer's name
     * @param student tells if the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
     * Adds a specific number of loyalty points.
     * @param points the points to add
     */
    public void addPoints(int points) {

        if (points > 0) {
            loyaltyPoints = loyaltyPoints + points;
        }
    }

    /**
     * Adds loyalty points based on the amount spent.
     * One point is earned for every 50 pesos.
     * @param amountSpent the total amount spent
     */
    public void addPoints(double amountSpent) {

        if (amountSpent >= 50) {
            int points = (int) (amountSpent / 50);
            loyaltyPoints = loyaltyPoints + points;
        }
    }

    /**
     * Gets the customer's name.
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name.
     * @param name the new customer name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Checks if the customer is a student.
     * @return true if the customer is a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the customer's student status.
     * @param student the new student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the customer's loyalty points.
     * @return the loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the customer's loyalty points.
     * Negative points are not accepted.
     * @param loyaltyPoints the new loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {

        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}

