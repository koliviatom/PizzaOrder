package application;

import java.io.Serializable;
/**
 * A class to store pizza information.
 * 
 * @author Olivia Tom
 *
 */
public class Pizza implements Serializable {
	
	private static final long serialVersionUID = 3281047558603886616L;
	
	private final String size;
	private final String cheese;
	private final String pineapple;
	private final String greenPepper;
	private final String ham;
		
	/**
	 * Full parameter constructor of Pizza object.
	 * @param size Size of the pizza.
	 * @param cheese Amount of cheese ordered.
	 * @param pineapple Amount of pineapple ordered.
	 * @param pepper Amount of green pepper ordered.
	 * @param ham Amount of ham ordered.
	 * @throws IllegalPizza if arguments not legal.
	 */
	public Pizza(String size, String cheese, String pineapple, String pepper, String ham) throws IllegalPizza {
		if (size == null)
			throw new IllegalPizza("Illegal size: " + size);
		switch(size) {
		case "small": case "Small":
			this.size = "Small";
			break;
		case "medium": case "Medium":
			this.size = "Medium";
			break;
		case "large": case "Large":
			this.size = "Large";
			break;
		default:
			throw new IllegalPizza("Illegal size: " + size);
		}
		if (cheese == null)
			throw new IllegalPizza("Illegal cheese: " + cheese);
		switch(cheese) {
		case "single": case "Single":
			this.cheese = "Single";
			break;
		case "double": case "Double":
			this.cheese = "Double";
			break;
		case "triple": case "Triple":
			this.cheese = "Triple";
			break;
		default:
			throw new IllegalPizza("Illegal cheese: " + cheese);
		}
		if (ham == null)
			throw new IllegalPizza("Illegal ham: " + ham);
		switch(ham) {
		case "single": case "Single":
			this.ham = "Single";
			break;
		case "none": case "None":
			this.ham = "None";
			break;
		default:
			throw new IllegalPizza("Illegal ham: " + ham);
		}
		if (pineapple == null)
			throw new IllegalPizza("Illegal pineapple: " + pineapple);
		switch(pineapple) {
		case "single": case "Single":
			if (!this.ham.equals("Single"))
				throw new IllegalPizza("You can't order pineapple without ham!");
			this.pineapple = "Single";
			break;
		case "none": case "None":
			this.pineapple = "None";
			break;
		default:
			throw new IllegalPizza("Illegal pineapple: " + pineapple);
		}
		if (pepper == null)
			throw new IllegalPizza("Illegal green pepper: " + pepper);
		switch(pepper) {
		case "single": case "Single":
			if (!this.ham.equals("Single"))
				throw new IllegalPizza("You can't order green pepper without ham!");
			greenPepper = "Single";
			break;
		case "none": case "None":
			greenPepper = "None";
			break;
		default:
			throw new IllegalPizza("Illegal green pepper: " + pepper);
		}
	}
	
	/**
	 * Default constructor that creates a small pizza with just single cheese and ham.
	 * @throws IllegalPizza
	 */
	public Pizza() throws IllegalPizza { 
		this("Small", "Single", "None", "None", "Single");
	}
	
	/**
	 * Gets the cost of a pizza.
	 * @return the cost of the pizza.
	 */
	public double getCost( ) {
		double cost = 0.00;
		if (this.size.equals("Small"))
			cost = 7.00;
		if (this.size.equals("Medium"))
			cost = 9.00;
		if (this.size.equals("Large"))
			cost = 11.00;
		if (this.cheese.equals("Double"))
			cost += 1.50;
		else if (this.cheese.equals("Triple"))
			cost += 3.00;
		if (this.pineapple.equals("Single"))
			cost += 1.50;
		if (this.greenPepper.equals("Single"))
			cost += 1.50;
		if (this.ham.equals("Single"))
			cost += 1.50;
		return cost;
	}
	
	/**
	 * A string representation of the current object.
	 * @return a string representation of the contents of the Pizza object.
	 */
	@Override
	public String toString() {
		String s = size + " pizza, " + cheese + " cheese";
		if (pineapple.equals("Single"))
			s += ", pineapple";
		if (greenPepper.equals("Single"))
			s += ", green pepper";
		if (ham.equals("Single"))
			s += ", ham";
		double cost = getCost();
		s += ". Cost: $" + String.format("%.2f", cost) +" each.";
		return s;
	}
	
	/**
     * Tests two Pizza objects for equality.
     * @param otherObj The other Pizza object.
     * @return <code>true</code> if all the attributes of both objects are exactly equal, <code>false</code>
     * otherwise.
     */
	@Override
	public boolean equals(Object otherObj) {
		boolean equals = false;
		if (otherObj instanceof Pizza) {
			Pizza otherPizza = (Pizza)otherObj;
			if (size.equals(otherPizza.size) && cheese.equals(otherPizza.cheese) && 
					pineapple.equals(otherPizza.pineapple) && 
					greenPepper.equals(otherPizza.greenPepper) &&
					ham.equals(otherPizza.ham))
				equals = true;
		}
		return equals;
	}
	
	/**
     * Returns a copy of the of the current Pizza object.
     * @return A copy of the current object.
     */
	@Override
	public Pizza clone() {
		Pizza pizzaCopy = null;
		try {
			pizzaCopy = new Pizza(size, cheese, pineapple, greenPepper, ham);
        } catch (IllegalPizza e) {
            // Should never get here!
            return null;
        } // end try/catch
		return pizzaCopy;
	}
}
