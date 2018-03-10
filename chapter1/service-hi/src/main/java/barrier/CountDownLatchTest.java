package barrier;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private static CountDownLatch latch = new CountDownLatch(5);
	static class BossThread extends  Thread{
		public void run() {
            System.out.println("Boss在会议室等待，总共有" + latch.getCount() + "个人开会...");
            try {
				latch.await();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("所有人都到齐了吧，开会");
		}
	}
	static class EmployeeThread extends Thread{
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+";到达会议室。。。");
			latch.countDown();
		}
	}
	public static void main(String[] args) {
		new BossThread().start();
		for (int i = 0; i<5; i++) {
			new EmployeeThread().start();
		}
	}
}
