package main.java.bean.character;

public interface IPowerful extends IEnergetic {

	boolean isPowerful();
	
	void setPowerful(boolean powerful);
	
	IPower getPower();
}
