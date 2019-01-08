package ss.week7.threads;

//Exercise 7.9
public class TestConsole extends Thread {
	
	public static void main(String[] args) {
		new TestConsole("Thread A").start();
		new TestConsole("Thread B").start();
	}
	
	public TestConsole(String name) {
		this.setName(name);
	}

	// overrides Thread.run

	public void run() {
		sum();
	}

	private void sum() {
		int e1 = Console.readInt(this.getName() + " Get number 1: ");
		int e2 = Console.readInt(this.getName() + " Get number 2: ");
		int sum = e1 + e2;
		Console.println(this.getName() + " " + e1 + " + " + e2 + " = " + sum);
	}
}
