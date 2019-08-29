package application;

/**
 * An Exception thrown by the Pizza Object if parameters are not legal.
 * <ul>
 * <li>The size must be "small", "medium" or "large".</li>
 * <li>Cheese must be "single", "double" or "triple".</li>
 * <li>Pineapple must be "none" or "single".</li>
 * <li>Green pepper must be "none" or "single".</li>
 * <li>Ham must be "none" or "single".</li>
 * <li>A Pizza cannot have pineapple or green pepper unless it has ham.</li>
 * </ul>
 * @author Olivia Tom
 */

public class IllegalPizza extends Exception {

	private static final long serialVersionUID = -5935590159508055457L;

	/**
	 * Supplies a default message.
	 */
	public IllegalPizza() {
		super("Illegal parameter value supplied to Pizza object.");
	}

	/**
	 * Passes along the message supplied to the exception.
	 * @param message A more specific message.
	 */
	public IllegalPizza(String message) {
		super(message);
	}

} // end IllegalHalloweenException
