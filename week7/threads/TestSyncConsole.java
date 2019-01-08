package ss.week7.threads;

public class TestSyncConsole extends Thread {
	public static void main(String[] args) {
		new TestSyncConsole("Thread A").start();
		new TestSyncConsole("Thread B").start();
	}
	
	public TestSyncConsole(String name) {
		this.setName(name);
	}

	// overrides Thread.run

	public void run() {
		sum();
	}

	private synchronized void sum() {
		int e1 = SyncConsole.readInt(currentThread().getName() + " Get number 1: ");
		int e2 = SyncConsole.readInt(currentThread().getName() + " Get number 2: ");
		int sum = e1 + e2;
		SyncConsole.println(this.getName() + " " + e1 + " + " + e2 + " = " + sum);
	}
}
