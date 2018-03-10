package lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class LockTest {
    static int count = 0;
    static volatile boolean finishStatus = false;
    static int sync_count = 0;
    public static synchronized void increase() {
    	sync_count++;
    }
    
    public static void testLock(Lock lock) {
        try {
            lock.lock();
            for (int i = 0; i < 1000000000; i++) ++count;
        } finally {
            lock.unlock();
        }
    }
    public static int test() {
    	final ClhSpinLock clh = new ClhSpinLock();
        final CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
            	finishStatus = true;
                //System.out.println(count);
            }
        });
        
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testLock(clh);
                    // 这段代码是非lock比较使用
//                    for (int i = 0; i < 10000000; i++)
//                        count++;
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while (true) {
        	if (finishStatus) {
        		break;
        	}
        }
        System.out.println(count);
        return count;
    }
    public static int test2() {
    	for (int i = 0; i < 10; i++) {
    		new Thread(new Runnable() {
    			@Override
    			public void run() {
    				for (int j=0; j< 100000000; j++) {
    					increase();
    				}
    			}
    		}).start();
    	}
    	System.out.println(count);
    	return count;
    }
    
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    	long a = System.currentTimeMillis();
    	test();
    	System.out.println(System.currentTimeMillis() - a);
    	test2();
    	System.out.println(System.currentTimeMillis() - a);
    	
    	
    }
}