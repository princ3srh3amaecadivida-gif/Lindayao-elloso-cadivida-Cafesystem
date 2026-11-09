 
/**
 * Represents a general menu item in the campus cafe.
 *
 * @author cadivida,lindayao,elloso
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor.
     */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the item price.
     * @return computed price
     */
    public abstract double computePrice();

    /**
     * Returns item description.
     * @return description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.isEmpty()) {
            this.itemCode = itemCode;
        }
    }
}

