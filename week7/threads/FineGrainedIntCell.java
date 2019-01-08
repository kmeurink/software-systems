package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Correct communication between IntProducer en IntConsumer.
 * Exercise 7.18
 */
public class FineGrainedIntCell implements IntCell {
	private boolean buffer = false;
	private int value = 0;
	private ReentrantLock intCellLock = new ReentrantLock();
	private final Condition consumedBuffer = intCellLock.newCondition();
	private final Condition producedBuffer = intCellLock.newCondition();

	public void setValue(int valueArg) {
		intCellLock.lock();
		try {
			while (buffer) {
				consumedBuffer.await();
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value = valueArg;
		buffer = true;
		producedBuffer.signal();
		intCellLock.unlock();
	}

	public int getValue() {
		intCellLock.lock();
		try {
			while (!buffer) {
				producedBuffer.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumedBuffer.signal();
		buffer = false;
		intCellLock.unlock();
		return value;
	}
}