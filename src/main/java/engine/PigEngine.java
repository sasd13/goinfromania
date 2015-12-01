package main.java.engine;

import main.java.bean.IElement;
import main.java.bean.character.pig.Pig;

public class PigEngine {

	public static Pig findPig(IElement[] elements) {
		for (IElement element : elements) {
			if ("PIG".equalsIgnoreCase(element.getClass().getSimpleName())) {
				return (Pig) element;
			}
		}
		
		return null;
	}
}
