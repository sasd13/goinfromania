package com.sasd13.goinfromania.view.arena.image;

import java.util.HashMap;
import java.util.Map;

import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.character.Pig;

public class DrawableFactory {
	
	private static Map<Class<? extends IElement>, IDrawable> map = new HashMap<>();

	private DrawableFactory() {
	}

	public static IDrawable make(IElement element) {
		IDrawable drawable = null;
		
		if (!map.containsKey(element.getClass())) {
			drawable = makeNew(element);
			map.put(element.getClass(), drawable);
		} else {
			drawable = map.get(element.getClass());
		}
		
		return drawable;
	}
	
	public static IDrawable makeNew(IElement element) {
		if (Pig.class.isAssignableFrom(element.getClass())) {
			return new PigDrawable();
		} else {
			return null;
		}
	}
}
