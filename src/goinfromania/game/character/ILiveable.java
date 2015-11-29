package goinfromania.game.character;

public interface ILiveable {
	
	int LIFE_MIN = 0;
	int LIFE_MEDIUM = 50;
	int LIFE_MAX = 100;

	boolean isAlive();
	
	int getLife();
	
	void setLife(int life);
}
