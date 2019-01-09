package ss.week7.account;


public class AccountSync {
	
	public static void main(String[] args) {
		//For loop to run the program 50 times
		for (int i = 0; i < 50; i++) { 
			Account bank = new Account();
			double amount = 500.0;
			int freq = 10;
		
			MyThread threadA = new MyThread(amount, freq, bank);
			MyThread threadB = new MyThread(-1 * amount, freq, bank);
			threadA.start();
			threadB.start();
			try {
				threadA.join();
				threadB.join();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("The final balance of the account is: " + bank.getBalance());
		} 
	}
}
