package java_baseball.domain;

import java.util.List;

public class Referee {

	public String compare(List<Integer> com, List<Integer> player) {
		int strike = 0;
		int ball = 0;
		
		Judgment judgment = new Judgment();
		int collectCount = judgment.collectCount(com, player);
		
		for (int i = 0; i < player.size(); i++) {
			if(judgment.hasPlace(com, i, player.get(i))) {
				strike++;
			}
		}
		ball = collectCount - strike;
		if (strike == 3) {
			return "정답입니다.";
		}
		
		if (collectCount == 0) {
			return "아웃";
		}
		return "Strike : " + strike + " Ball : "+ball;
	}
}
