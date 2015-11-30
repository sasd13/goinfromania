package goinfromania.game;

public class Player {

	private static int count = 0;
	
	private String name;
	private Game[] games;
	
	public Player() {
		count++;
		
		setName("Joueur "+count);
	}
	
	public Player(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Game[] getGames() {
		return games;
	}
	
	public void setGames(Game[] games) {
		this.games = games;
	}
}
