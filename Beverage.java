
/**
 * This class is used for beverage menu items.
 * It extends the MenuItem class.
 * @author Princes Rheamae
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    /**
     * Default constructor for Beverage.
     */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Constructor with parameters.
     * @param name the name of the beverage
     * @param basePrice the original price
     * @param itemCode the code of the beverage
     * @param size the size of the beverage
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
     * Computes the price based on the beverage size.
     * @return the final beverage price
     */
    @Override
    public double computePrice() {

        // Small size has no additional charge.
        if (size.equals("S")) {
            return basePrice;
        }
        // Medium size adds 15 pesos.
        else if (size.equals("M")) {
            return basePrice + 15;
        }
        // Large size adds 25 pesos.
        else {
            return basePrice + 25;
        }
    }

    /**
     * Displays the beverage name, code, and size.
     * @return the beverage description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the beverage size.
     * @return the beverage size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the beverage size.
     * Only S, M, and L are accepted.
     * @param size the new beverage size
     */
    public void setSize(String size) {

        // Check if the size is valid.
        if (size.equals("S") || size.equals("M") || size.equals("L")) {
            this.size = size;
        } else {
            System.out.println("Invalid size. Please use S, M, or L.");
        }
    }
}

