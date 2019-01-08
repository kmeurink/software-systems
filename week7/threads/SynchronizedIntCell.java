package ss.week7.threads;

/**
 * Correct communication between IntProducer en IntConsumer.
 */
public class SynchronizedIntCell implements IntCell {
	private boolean buffer = false;
	private int value = 0;

	public synchronized void setValue(int valueArg) {
		while (buffer) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.value = valueArg;
		buffer = true;
		this.notifyAll();

	}

	public synchronized int getValue() {
		try {
			while (!buffer) {
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.notifyAll();
		buffer = false;
		return value;
	}
}


