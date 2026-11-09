
/**
 * This class is used for pastry menu items.
 * It extends the MenuItem class.
 * @author Princes Rheamae
 * @version 1.0
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    /**
     * Default constructor for Pastry.
     */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Constructor with parameters.
     * @param name the name of the pastry
     * @param basePrice the original price
     * @param itemCode the code of the pastry
     * @param warmed tells if the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the pastry price.
     * @return the final pastry price
     */
    @Override
    public double computePrice() {

        // Add 10 pesos if the pastry is warmed.
        if (warmed) {
            return basePrice + 10;
        } else {
            return basePrice;
        }
    }

    /**
     * Displays the pastry description.
     * @return the pastry name, code, and warming status
     */
    @Override
    public String getDescription() {

        if (warmed) {
            return super.getDescription() + " (Warmed)";
        } else {
            return super.getDescription();
        }
    }

    /**
     * Checks if the pastry is warmed.
     * @return true if warmed, otherwise false
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets the warming status of the pastry.
     * @param warmed the new warming status
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}

