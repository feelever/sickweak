package event.delegation;

public class GoodNotifier extends Notifier{

	@Override
	public void registerListener(Object object, String methodName, Object... args) {
		System.out.println("来生意了，接活");
		this.getEventHandler().registerEvent(object, methodName, args);
	}

	@Override
	public void notifyX() {
		System.out.println("尽职尽责的放哨人告诉所有需要帮忙的同学：老师来了");     
        try{     
            this.getEventHandler().notifyX();     
        }catch(Exception e){     
            e.printStackTrace();     
        }     
	}

}
