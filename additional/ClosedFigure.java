package ss.additional;

/**
 * exercise 9.2 recommended exercises.
 */

/**
 * interface encompassing both the Rectangle and Circle class.
 * This only includes area and perimeter, as other methods are not shared.
 * @author kester.meurink
 *
 */
public interface ClosedFigure {

	/**
	 * Method calculating the perimeter of the created ClosedFigure.
	 */
	public void perimeter();
	
	/**
	 * Method calculating the area of the created ClosedFigure;
	 */
	public void area();
}
