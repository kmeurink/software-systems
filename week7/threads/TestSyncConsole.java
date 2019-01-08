package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		new TestSyncConsole("Thread A").start();
		new TestSyncConsole("Thread B").start();
	}
	
	public TestSyncConsole(String name) {
		this.setName(name);
	}
	
	public TestSyncConsole(String name, ReentrantLock lock) {
		this.setName(name);
		this.lock = lock;
	}

	// overrides Thread.run

	public void run() {
		sum();
	}

	private void sum() {
		lock.lock();
		int e1 = SyncConsole.readInt(currentThread().getName() + " Get number 1: ");
		int e2 = SyncConsole.readInt(currentThread().getName() + " Get number 2: ");
		int sum = e1 + e2;
		SyncConsole.println(this.getName() + " " + e1 + " + " + e2 + " = " + sum);
		lock.unlock();
	}
}
