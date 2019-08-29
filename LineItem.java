package application;

import java.io.Serializable;

public class LineItem implements Comparable<LineItem>, Serializable {
	
	private static final long serialVersionUID = 1734632392830834312L;
	
	private int numPizza;
	private final Pizza pizza;

	/**
	 * Full parameter constructor of LineItem objects.
	 * @param number the number of pizza's to be ordered.
	 * @param pizza the type of pizza to be ordered, a Pizza object.
	 * @throws IllegalPizza if pizza is not a Pizza object.
	 */
	public LineItem(int number, Pizza pizza) throws IllegalPizza {
		setNumber(number);
		if (!(pizza instanceof Pizza))
			throw new IllegalPizza("Illegal Pizza: " + pizza);
		this.pizza = pizza;
	}
	
	/**
	 * Partial constructor that defaults number of pizza's to 1.
	 * @param pizza pizza the type of pizza to be ordered, a Pizza object.
	 * @throws IllegalPizza if pizza is not a Pizza object.
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		setNumber(1);
		if (!(pizza instanceof Pizza))
			throw new IllegalPizza("Illegal Pizza: " + pizza);
		this.pizza = pizza;
	}
	
	/**
	 * Sets the numPizza attribute.
	 * @param num the number of pizza's to be ordered.
	 * @throws IllegalPizza if num is less than 1 or above 100.
	 */
	public void setNumber(int num) throws IllegalPizza {
		if (num < 1 || num > 100)
			throw new IllegalPizza("Illegal number of pizzas: " + num);
		numPizza = num;
	}
	
	/**
	 * Gets the numPizza attribute.
	 * @return the numPizza attribute.
	 */
	public int getNumber() {
		return numPizza;
	}
	
	/**
	 * Gets the pizza attribute.
	 * @return the pizza attribute.
	 */
	public Pizza getPizza() {
		return pizza;
	}
	
	/**
	 * Gets the cost of a pizza order, applying discounts.
	 * @return the discounted cost of a pizza order.
	 */
	public double getCost() {
		double cost = pizza.getCost() * numPizza;
		if (numPizza > 20)
			cost = cost *.90;
		else if (numPizza >= 10)
			cost = cost * 0.95;
		return cost;
	}
	
	/**
	 * Converts a Pizza object to a string representation.
	 * @return a string representation of a Pizza object.
	 */
	@Override
	public String toString() {
		String s = "";
		if (numPizza < 10)
			s = " ";
		s += numPizza + " " + pizza.toString();
		return s;
	}
	
	/**
     * Compares LineItem objects on the basis of the total cost only.
     * @param otherItem The other LineItem object.
     * @return A negative <code>int</code> if the supplied object has a greater cost, zero if the
     * cost difference is less than 1 and a positive number if the current object has a greater cost.
     */
	public int compareTo(LineItem otherItem) {
		int output = 0;
		double diff = otherItem.getCost() - this.getCost();
		if (diff > 1)
			output = 1;
		else if (diff < -1)
			output = -1;
		return output;
	}
}
