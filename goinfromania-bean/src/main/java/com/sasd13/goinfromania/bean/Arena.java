package com.sasd13.goinfromania.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Arena extends Observable {

	private Game game;
	private List<IElement> elements;
	private IPig pig;

	public Arena(Game game) {
		this.game = game;

		elements = new ArrayList<>();
	}

	public Game getGame() {
		return game;
	}

	public List<IElement> getElements() {
		return elements;
	}

	public void addElement(IElement element) {
		elements.add(element);

		setChanged();
		notifyObservers();
	}

	public void removeElement(IElement element) {
		elements.remove(element);

		setChanged();
		notifyObservers();
	}

	public IPig getPig() {
		return pig;
	}

	public void setPig(IPig pig) {
		this.pig = pig;

		addElement(pig);
	}
}
