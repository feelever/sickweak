package sync;

public class SynchronizedTest {
	public synchronized void test1() {
		
	}
	public void test2() {
		synchronized (this) {
			
		}
	}
}
