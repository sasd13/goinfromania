package main.java.controller.anim;

import java.util.ArrayList;

public class AnimationHandler {

	private static ArrayList<Animation> listAnimations = new ArrayList<>();
	
	public static void prepare(Animation animation) {
		if (!listAnimations.contains(animation)) {
			listAnimations.add(animation);
		}
	}
	
	public static void start(Animation animation) {
		prepare(animation);
		animation.start();
	}
	
	public static void startAll() {
		for (Animation animation : listAnimations) {
			start(animation);
		}
	}
	
	public static void stop(Animation animation) {
		animation.stop();
	}
	
	public static void stopAll() {
		for (Animation animation : listAnimations) {
			stop(animation);
		}
	}
	
	public static void finish(Animation animation) {
		stop(animation);		
		listAnimations.remove(animation);
	}
	
	public static void finishAll() {
		stopAll();		
		listAnimations.clear();
	}
}
