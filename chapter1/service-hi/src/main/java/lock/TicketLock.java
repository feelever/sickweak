package lock;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
  private AtomicInteger serviceNum = new AtomicInteger();
  private AtomicInteger ticketNum = new AtomicInteger();
  public int lock() {
	  int myTicketNum = ticketNum.getAndIncrement();
	  while(serviceNum.get() != myTicketNum) {
		  
	  }
	  return myTicketNum;
  }
  public int unlock(int myTicket) {
	  int next = myTicket++;
	  serviceNum.compareAndSet(myTicket, next);
	  return next;
  }
}
