package ss.week6;
/**
 * An exception class to react when there are not enough arguments provided.
 * @author kester.meurink
 *
 */
public class TooFewArgumentsException extends WrongArgumentException {
	
	public TooFewArgumentsException() {
		super();
	}
	@Override
	public String getMessage() {
		return "error: too few command line arguments";
	}
}
