package com.forezp.poolDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	final static int corePoolSize =5;
	final static int maximumPoolSize =10;
	final static long keepAliveTime = 200;
	final static ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
	public static void main(String[] args) {
		ThreadPoolExecutor excutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue);
		for (int i = 0; i < 20; i++) {
			MyRunnable run = new MyRunnable(i);
			excutor.execute(run);
		    System.out.println("线程池中现在的线程数目是："+excutor.getPoolSize()+",  队列中正在等待执行的任务数量为："+  
      		excutor.getQueue().size());  
		}
		excutor.shutdown(); 
	}
}
