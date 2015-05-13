package game.util;

public class ThreadSleeper {

	public static void defaultSleep() {
		sleep(300);
	}
	
	public static void sleep(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
