package threadlocal;

public class ThreadLocalDemo {
	private static final ThreadLocal<Integer> count =  new ThreadLocal<Integer>() {
	 @Override
        protected Integer initialValue() {
            return 0;
        }
    };
	static class Increase implements Runnable{
		private int index;
		public Increase(int index) {
			this.index = index;
		}
		@Override
		public void run() {
			System.out.println("线程"+index+"的初始化value:" +count.get());
			for (int i = 0; i < 10; i++) {
				count.set(count.get() + i);
            }
            System.out.println("线程" + index + "的累加value:" + count.get());
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Increase(i)).start();
		}
	}
}
