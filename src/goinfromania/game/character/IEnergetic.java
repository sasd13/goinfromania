package goinfromania.game.character;

public interface IEnergetic {
	
	int ENERGY_MIN = 0;
	int ENERGY_MEDIUM = 50;
	int ENERGY_MAX = 100;
	
	boolean hasEnergy();
	
	int getEnergy();
	
	void setEnergy(int energy);
}
