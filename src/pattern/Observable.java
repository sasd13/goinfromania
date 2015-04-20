package pattern;


public interface Observable {	
	
	boolean addObserver(Observer observer);
	boolean removeObserver(Observer observer);
	void notifyObservers();
}
