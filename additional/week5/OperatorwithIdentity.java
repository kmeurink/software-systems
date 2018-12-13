package ss.additional.week5;

public interface OperatorwithIdentity {
	
	/**
	 * Perform this operation with the specified operands.
	 */
	public int operate(int left, int right);
	
	/**
	 * The identity for this operator.
	 *  For any int i, this.operate(this.identity(), i) == 
	 *  this.operate(i, this.identity()) == i 
	 */
	public int identity();

}
