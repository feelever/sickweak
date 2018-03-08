package happensbefore;

public class HappensBefore {
	/**
	 * happenBefore dim:
	 * if A happens before B means: B can view A's result & A before B
	 * if resort result same as original resort is legal 
	 */
	/**
	 * rule:
	 * 1.program sequence rule: in a thread code before will happen before after;
	 * 2.lock rule: an unlock operate happen before latter lock operate(same object);  
	 * 3.volatile variable rule: operate a object,write always happen before read;
	 * 4.transfer rule: A happens before B ,B happens before C then A happens before C;
	 * 5.thread start rule: method start() happens before any action in this thread;
	 * 6.thread interrupt rule: interrupt() happens before the interrupted thread check the interrupted event;
	 * 7.thread terminate rule: in a thread all action happen before terminate check;
	 * 8.object terminate rule: object initialize happens before finalize();
	 */
	/**
	 * extension rule
	 * put a element into a thread-safe queue happens before take this element;
	 * put a element into a thread-safe container happens before take this element;
	 * CountDownLatch's minus happen before await();
	 * release semaphore's operation happens before achieve promise;
	 * future's operations happens before future.get();
	 * submit a Runnable or Callable to executor happens before task begin
	 */
}
