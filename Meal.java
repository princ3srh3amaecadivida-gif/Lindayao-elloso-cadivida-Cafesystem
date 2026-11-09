
/**
 * This class is used for meal menu items.
 * It extends the MenuItem class.
 * @author Princes Rheamae
 * @version 1.0
 */
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor for Meal.
     */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Constructor with parameters.
     * @param name the name of the meal
     * @param basePrice the original price
     * @param itemCode the code of the meal
     * @param upsized tells if the meal is upsized
     * @param extraSides the number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes the total price of the meal.
     * @return the final meal price
     */
    @Override
    public double computePrice() {

        double price = basePrice;

        // Add 20 pesos if the meal is upsized.
        if (upsized) {
            price = price + 20;
        }

        // Add 12 pesos for every extra side.
        price = price + (extraSides * 12);

        return price;
    }

    /**
     * Displays the meal description.
     * @return the meal name, code, and options
     */
    @Override
    public String getDescription() {

        String description = super.getDescription();

        if (upsized) {
            description = description + " Upsized";
        } else {
            description = description + " Regular";
        }

        description = description + ", " + extraSides + " side(s)";

        return description;
    }

    /**
     * Gets the upsize status.
     * @return true if upsized, otherwise false
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets the upsize status.
     * @param upsized the new upsize status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides.
     * Negative values are not accepted.
     * @param extraSides the number of extra sides
     */
    public void setExtraSides(int extraSides) {

        // Extra sides cannot be negative.
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}

