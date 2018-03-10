package event.delegation;

public abstract class Notifier {
	private EventHandler eventHandler = new EventHandler();
	
	public EventHandler getEventHandler() {     
        return eventHandler;     
    }
	public void setEventHandler(EventHandler eventHandler) {     
       this.eventHandler = eventHandler;     
    }
	public abstract void registerListener(Object object,String methodName,Object...args);
    //告诉所有要帮忙放哨的学生：老师来了     
    public abstract void notifyX();
}
