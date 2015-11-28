package goinfromania.character;

public interface IEnergetic {
	
	int ENERGY_MEDIUM = 50;
	int ENERGY_MAX = 100;
	
	boolean hasEnergy();
	
	int getEnergy();
	
	void setEnergy(int energy);
}
