package game.round;

public class RoundManager {

	public static Round load(String roundId) {
		Round round = null;
		
		//Database query
		
		return round;
	}
	
	public static ListRound loadAll() {
		ListRound listRound = new ListRound();
		
		String[] tabRoundId = new String[1]; //Database query
		
		Round round;
		for(String roundId : tabRoundId) {
			round = load(roundId);
			listRound.add(round);
		}
		
		return listRound;
	}
	
	public static void save(Round round) {
		//Database query
	}
	
	public static void saveAll(ListRound listRound) {
		for (int i=0; i<listRound.size(); i++) {
			save(listRound.get(i));
		}
	}
}
