package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.character.pig.Pig;

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
