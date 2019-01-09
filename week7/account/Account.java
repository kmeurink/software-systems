package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private static ReentrantLock lock = new ReentrantLock();
	protected double balance = 0.0;
	private static final Condition tooLow = lock.newCondition();

	public void transaction(double amount) {
		lock.lock();
		while (this.getBalance() + amount < -1000) {
			try {
				tooLow.await();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			balance = balance + amount;
		} 
		tooLow.signal();
		lock.unlock();
	}
	public double getBalance() {
		return balance;

	}
}
