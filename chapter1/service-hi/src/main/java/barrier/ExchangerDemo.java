package barrier;

import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.FutureTask;

public class ExchangerDemo {
    static Exchanger<String>exchanger=new Exchanger<String>();
    static class Task implements Callable<String>{
        @Override
        public String call() {
            try {
                String result=exchanger.exchange(Thread.currentThread().getName());
                System.out.println("this is "+Thread.currentThread().getName()+" receive data:"+result);
                return result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static void main(String[] args)throws Exception {
    	//Thread.sleep(50000000);
    	int i= 0;  
    	while(true) {
    		System.out.println(i++);
    	}
    	/*FutureTask<String> task = new FutureTask<>(new Task());
    	FutureTask<String> task2 = new FutureTask<>(new Task());
    	task.get();
    	task2.get();*/
		/*Thread t1 = new Thread(new Task(),"Thread1");
		Thread t2= new Thread(new Task(),"Thread2");*/
		/*t1.start();
		t2.start();
		t1.join();
		t2.join();*/
	}
}
