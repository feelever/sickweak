package event.delegation;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
	private List<Event> objs;
	public EventHandler() {
		objs = new ArrayList<Event>();
	}
	public void registerEvent(Object object,String methodName,Object...args) {
		objs.add(new Event(object,methodName,args));
	}
	public void notifyX() throws Exception{     
        for(Event e : objs){     
            e.invoke();     
        }     
    } 
}
