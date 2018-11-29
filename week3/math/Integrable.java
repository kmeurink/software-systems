package ss.week3.math;

public interface Integrable extends Function{

	
	/**
	 * @return Returns the Function object that is an integral of the current function.
	 */
	public Integrable integral();
}
