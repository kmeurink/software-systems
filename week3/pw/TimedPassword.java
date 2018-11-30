package ss.week3.pw;

/**
 * A password that also has an expiration moment, allowing for better security.
 * @author kester.meurink
 *
 */

public class TimedPassword extends Password{
	
	private long startTime;
	private long validTime;
	private long expTime;
	
	/**
	 * Constructor allowing the user to set the expiry time.
	 * @param validTime - The duration a password is valid.
	 */
	public TimedPassword(long validTime) {
		startTime = System.currentTimeMillis();
		this.validTime = validTime;
		
	}
	/**
	 * Default constructor, in case no argument is provided.
	 */
	public TimedPassword() {
		this.validTime = 1;
	}
	
	//Queries:
	
	/**
	 * Check if the created password is still valid.
	 * @return true if the password has not yet expired.
	 */
	public boolean isExpired() {
		expTime = System.currentTimeMillis();
		long time = expTime - startTime;
		return time >= validTime;
	}
	
	/**
	 * Override setWord method of Password, to include a reset of the expiry date.
	 */
	@Override
	public boolean setWord(String oldpass, String newpass) {
		super.setWord(oldpass, newpass);
		this.startTime = System.currentTimeMillis();
		return true;

	}

}
