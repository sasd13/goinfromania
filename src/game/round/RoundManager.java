package game.round;

public class RoundManager {

	public static Round load(String roundId) {
		//Database query
		return null;
	}
	
	public static ListRound loadAll() {
		ListRound listRound = new ListRound();
		
		String[] tabRoundId = new String[0]; //Database query
		
		Round round;
		for(String roundId : tabRoundId) {
			round = load(roundId);
			listRound.add(round);
		}
		
		return listRound;
	}
	
	public static boolean save(Round round) {
		return false;
	}
}
