package barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
	private static CyclicBarrier barrier;
	static class BarrierThread extends Thread{
		public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            try {
            	Thread.sleep(500);
				barrier.await(500,TimeUnit.MILLISECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		barrier = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				barrier.reset();
				System.out.println(barrier.getNumberWaiting());
				System.out.println("人到齐了，go");
			}
			
		});
		for (int i = 0; i<3;i++) {
			new BarrierThread().start();
		}
	}
}
