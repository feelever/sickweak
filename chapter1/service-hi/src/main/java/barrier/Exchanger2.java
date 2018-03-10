package barrier;

import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exchanger2 {
	static class Car implements Callable<String>{
	    private Exchanger<String> exchanger;
	    public Car(Exchanger<String> exchanger) {
	        super();
	        this.exchanger = exchanger;
	    }
	    @Override
	    public String call() throws Exception{
	        try {
	            System.out.println("car:" + Thread.currentThread().getName() + ": " + exchanger.exchange("Car"));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return exchanger.exchange("Car");
	    }
	}
	
	static class Bike implements Callable<String> {
	    private Exchanger<String> exchanger;

	    public Bike(Exchanger<String> exchanger) {
	        super();
	        this.exchanger = exchanger;
	    }

		@Override
		public String call() throws Exception {
			 try {
		            System.out.println("bike:" + Thread.currentThread().getName() + ": " + exchanger.exchange("Bike"));
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			return exchanger.exchange("Bike");
		}
	}
	
	public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Car car = new Exchanger2.Car(exchanger);
        Bike bike = new Exchanger2.Bike(exchanger);
        ExecutorService  excutor = Executors.newCachedThreadPool();
        excutor.submit(car);
        Future<String> str1 = excutor.submit(bike);
        Future<String> str2 = excutor.submit(car);
        try {
			System.out.println("bike:" + str1.get());
			System.out.println("car:"+ str2.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Main end!");
    }
}
