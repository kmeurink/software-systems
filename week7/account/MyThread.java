package ss.week7.account;

public class MyThread extends Thread {
	//Named constants:
	double theAmount;
	int theFrequency;
	Account theAccount;
	
	//Constructors:
	public MyThread(double amount, int frequency, Account account) {
		this.theAmount = amount;
		this.theFrequency = frequency;
		this.theAccount = account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < this.theFrequency; i++) {
			theAccount.transaction(this.theAmount);
			System.out.println("The final balance of the account is: " + this.theAccount.getBalance());
		}
	}
	
}
