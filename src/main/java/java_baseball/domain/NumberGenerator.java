package java_baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
	private final int BALLS_LENGTH = 3;

	public List<Integer> createRandomNumbers() {
		List<Integer> comNum = new ArrayList<>();
		while(comNum.size() < BALLS_LENGTH) {
			int number = new Random().nextInt(9) + 1;
			if (!comNum.contains(number)) {
				comNum.add(number);
			}
		}
		return comNum;
	}
}
