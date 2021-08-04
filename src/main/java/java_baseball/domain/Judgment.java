package java_baseball.domain;

import java.util.List;

public class Judgment {
	public int collectCount(List<Integer> com, List<Integer> player) {
		int result = 0;
		for (int i = 0; i < player.size(); i++) {
			
			if (com.contains(player.get(i))) {
				result++;
			}
		}
		return result;
	}

	public boolean hasPlace(List<Integer> com, int placeIndex, int ballNo) {
		return com.get(placeIndex) == ballNo; 
	}
}
