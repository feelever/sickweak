package lock;

import java.util.concurrent.atomic.AtomicReference;

public class SimpleSpinLock {
	private AtomicReference<Thread> owner = new AtomicReference<Thread>();
	public void lock() {
		Thread currThread = Thread.currentThread();
		while(owner.compareAndSet(null, currThread)) {
			
		}
	}
	public void unlock() {
		Thread currThread = Thread.currentThread();
		owner.compareAndSet(currThread, null);
	}
}
