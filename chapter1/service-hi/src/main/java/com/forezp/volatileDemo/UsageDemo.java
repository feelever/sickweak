package com.forezp.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsageDemo {
	public static volatile int bad_count = 0;
	private static AtomicInteger ok_count = new AtomicInteger(0);
	private static int lock_count = 0;
	private static int sync_count = 0;
	private  Lock lock = new ReentrantLock();
	public  void badIncrease() {
		bad_count++;
	}
	public  void atomicIncrease() {
		ok_count.getAndIncrement();
	}
	public  void lockIncrease() {
		lock.lock();
		lock_count++;
		lock.unlock();
	}
	public synchronized void syncIncrease() {
		sync_count++;
	}
	public void sayHow() {
		System.out.println("bad_count:" + bad_count);
		System.out.println("ok_count:" + ok_count);
		System.out.println("lock_count:" + lock_count);
		System.out.println("sync_count:" + sync_count);
	}
	public static void main(String[] args) {
		UsageDemo ud = new UsageDemo();
		for (int i=0; i<10; i++) {
			new Thread(()-> {
				for(int j = 0; j<1000; j++) {
					ud.atomicIncrease();
					ud.badIncrease();
					ud.lockIncrease();
					ud.syncIncrease();
				}
			}).start();
		}
		System.out.println(Thread.activeCount());
		while(Thread.activeCount()==1) {
			ud.sayHow();
		}
	}
}
