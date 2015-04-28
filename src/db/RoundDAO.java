package db;

import game.round.ListRounds;
import game.round.Round;

public class RoundDAO {

	public static Round load(String roundId) {
		Round round = null;
		
		//Database query
		
		return round;
	}
	
	public static ListRounds loadAll() {
		ListRounds listRounds = new ListRounds();
		
		String[] tabRoundId = new String[1]; //Database query
		
		Round round;
		for(String roundId : tabRoundId) {
			round = load(roundId);
			if (round != null) {
				listRounds.add(round);
			}
		}
		
		return listRounds;
	}
	
	public static void save(Round round) {
		//Database query
	}
	
	public static void saveAll(ListRounds listRounds) {
		for (int i=0; i<listRounds.size(); i++) {
			save(listRounds.get(i));
		}
	}
}
