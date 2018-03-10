package lock;

public class Singleton {
	private volatile static Singleton singleton;
	public Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return this.singleton;
	}
	private static class SingletonHolder {
		public static  Singleton singleton = new Singleton();
	}
	public static Singleton getInstance2(){
        return SingletonHolder.singleton;
    }
}
